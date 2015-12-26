package me.joshuadriesman.clusteringusingkruskals;

import java.io.IOException;
import java.util.*;

/**
 * Created by Joshua Driesman on 10/20/2015.
 *
 * Copyright 2015 Joshua Driesman
 */
public class Main {
    public static void main(String[] args) {
        Main m = new Main();

        String arffFileLocation = "";
        int numOfClusters = 1;
        String clusterResultsOutput = "./clusters.txt";
        String purityResultsOutput = "./purity.csv";

        switch (args.length)
        {
            case 0: System.out.println("An input file is required.");
                return;
            case 1: arffFileLocation = args[0];
                break;
            case 2: arffFileLocation = args[0];
                numOfClusters = Integer.getInteger(args[1]);
                break;
            case 3: arffFileLocation = args[0];
                numOfClusters = Integer.getInteger(args[1]);
                clusterResultsOutput = args[2];
                break;
            case 4: arffFileLocation = args[0];
                numOfClusters = Integer.getInteger(args[1]);
                clusterResultsOutput = args[2];
                purityResultsOutput = args[3];
                break;
        }

        m.runAlgorithm(arffFileLocation, clusterResultsOutput, purityResultsOutput, numOfClusters);

        System.out.println("See results.csv for cluster numbers and purity.");
    }

    /**
     * Executes Kruskal's Clustering Algorithm using the UnionFind data structure.
     * @param dataFile the file containing the data for the nodes we want to cluster
     * @param purityResultFile the location were the software should put the result file
     * @param numClustersToForm the number of clusters to form before exiting.
     */
    public void runAlgorithm(String dataFile, String clustersResultFile,
                             String purityResultFile, int numClustersToForm) {
        Parser parser = new ArffParser(dataFile);
        ResultWriter purityWriter;
        ResultWriter clusterWriter;

        try {
            purityWriter = new ResultWriter(purityResultFile, true);
            purityWriter.writeLine("NumOfClusters, Purity");
        } catch (IOException e) {
            throw new IllegalStateException("Can not write purity result file!");
        }

        try {
            clusterWriter = new ResultWriter(clustersResultFile, true);
        } catch (IOException e) {
            throw new IllegalStateException("Can not write cluster result file!");
        }

        List<LineData> lines = parser.parseWhole();

        UnionFind unionFind = new UnionFind(lines);

        List<Edge> edges = unionFind.getEdges();

        int clustersFormed = lines.size();

        for (Edge e : edges) {
            if (unionFind.union(e)) {
                clustersFormed--;

                String lineToWrite = clustersFormed + ", " + calculatePurity(unionFind.getClusters());
                try {
                    purityWriter.writeLine(lineToWrite);
                } catch (IOException e1) {
                    System.out.println("Could not write line to file, which may result in lost data." +
                            " Line: " + lineToWrite);
                }
            }
            if (clustersFormed == numClustersToForm) {
                break;
            }
        }

        IdentityHashMap<LineData, LinkedList<LineData>> clusters = unionFind.getClusters();
        for (Map.Entry<LineData, LinkedList<LineData>> cluster : clusters.entrySet()) {
            try {
                clusterWriter.writeLine(cluster.getValue().toString());
            } catch (IOException e) {
                System.out.println("Could nt write line to file, which may result in lost data.");
            }
        }

        try {
            purityWriter.close();
            clusterWriter.close();
        } catch (IOException e) {
            System.out.println("Could not close writer, or writer is already closed.");
        }
    }

    /**
     * Calculates the purity of the clusters.
     * @param graph the graph of clusters to calculated the purity of
     * @return the purity
     */
    public double calculatePurity(IdentityHashMap<LineData, LinkedList<LineData>> graph) {
        double totalNumOfMajority = 0;
        double totalNumOfSamples = 0;

        for (Map.Entry<LineData, LinkedList<LineData>> e : graph.entrySet()) {
            totalNumOfMajority += countMajority(e.getValue());
            totalNumOfSamples += e.getValue().size();
        }

        return totalNumOfMajority/totalNumOfSamples;
    }

    private int countMajority(LinkedList<LineData> value) {
        HashMap<String, Integer> numLabels = new HashMap<>();

        for (LineData node : value) {
            if (!(node instanceof ImageSegment)) {
                throw new IllegalStateException("Can not count majority in non-ImageSegment type.");
            }
            ImageSegment seg = (ImageSegment) node;
            String label = seg.getLabel();

            if (Objects.isNull(numLabels.get(label))) {
                numLabels.put(label, 1);
            } else {
                numLabels.put(label, numLabels.get(label) + 1);
            }
        }

        Collection<Integer> counts = numLabels.values();

        return Collections.max(counts);
    }
}
