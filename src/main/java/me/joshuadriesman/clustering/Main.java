package me.joshuadriesman.clustering;

import java.io.IOException;
import java.util.*;

/**
 * Created by Joshua Driesman on 10/20/2015.
 *
 * Copyright 2015 Joshua Driesman, All rights reserved
 */
public class Main {
    public static void main(String[] args) {
        Main m = new Main();

        m.runAlgorithm("src/main/resources/segment-full.arff", "results.csv", 1);

        System.out.println("See results.csv for cluster numbers and purity.");
    }

    /**
     * Excutes Kruskal's Clustering Algorithm using the UnionFind data structure.
     * @param dataFile the file containing the data for the nodes we want to cluster
     * @param resultFile the location were the software should put the result file
     * @param numClustersToForm the number of clusters to form before exiting.
     */
    public void runAlgorithm(String dataFile, String resultFile, int numClustersToForm) {
        Parser parser = new ArffParser(dataFile);
        ResultWriter writer;

        try {
            writer = new ResultWriter(resultFile, true);
            writer.writeLine("NumOfClusters, Purity");
        } catch (IOException e) {
            throw new IllegalStateException("Can not write result file!");
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
                    writer.writeLine(lineToWrite);
                } catch (IOException e1) {
                    throw new IllegalStateException("Could not write line to file! Line: " + lineToWrite);
                }
            }
            if (clustersFormed == numClustersToForm) {
                break;
            }
        }

        try {
            writer.close();
        } catch (IOException e) {
            throw new IllegalStateException("Could not close writer, or writer is already closed.");
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
