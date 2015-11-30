package me.joshuadriesman.clustering;

import java.util.*;

/**
 * Created by Joshua Driesman on 11/29/2015.
 *
 * Copyright 2015 Joshua Driesman, All rights reserved
 */
public class UnionFind implements UnionFindInterface{
    private List<Edge> edges  = new ArrayList<>();
    private HashMap<LineData, LineData> representatives = new HashMap<>();
    private HashMap<LineData, LinkedList<LineData>> clusters = new HashMap<>();

    public UnionFind(List<LineData> segments) {
        for (int i = 0; i < segments.size() - 1; i++) {
            LineData nodeA = segments.get(i);

            //Make an edge between every node.
            for (int i2 = i + 1; i2 < segments.size(); i2++) {
                LineData nodeB = segments.get(i2);

                edges.add(new Edge(nodeA, nodeB));
            }

            //Initialize representatives list
            representatives.put(nodeA, nodeA);

            LinkedList<LineData> initialCluster = new LinkedList<>();
            initialCluster.push(nodeA);
            clusters.put(nodeA, initialCluster);

        }
        Collections.sort(edges);
    }

    @Override
    public LineData find(LineData i) {
        return representatives.get(i);
    }

    @Override
    public void union(Edge e) {

    }

    public List<Edge> getEdges() {
        return edges;
    }

    public HashMap<LineData, LineData> getRepresentatives() {
        return representatives;
    }

    public HashMap<LineData, LinkedList<LineData>> getClusters() {
        return clusters;
    }
}
