package me.joshuadriesman.clustering;

import java.util.List;

/**
 * Created by Joshua Driesman on 10/20/2015.
 *
 * Copyright 2015 Joshua Driesman, All rights reserved
 */
public class Main {
    public static void main(String[] args) {
        Main m = new Main();

        m.runAlgorithm("src/main/resources/segment-full.arff", 1);
    }

    public void runAlgorithm(String dataFile, int numClustersToForm) {
        Parser parser = new ArffParser(dataFile);
        List<LineData> lines = parser.parseWhole();

        UnionFind unionFind = new UnionFind(lines);

        List<Edge> edges = unionFind.getEdges();

        int clustersFormed = lines.size();

        for (Edge e : edges) {
            if (unionFind.union(e)) {
                clustersFormed--;
                System.out.println("At " + clustersFormed + " clusters!");
            }
            if (clustersFormed == numClustersToForm) {
                break;
            }
        }
    }
}
