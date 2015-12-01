package me.joshuadriesman.clustering;

import java.util.*;

/**
 * Created by Joshua Driesman on 11/29/2015.
 *
 * Copyright 2015 Joshua Driesman, All rights reserved
 */
public class UnionFind implements UnionFindInterface{
    private List<Edge> edges  = new LinkedList<>();
    private IdentityHashMap<LineData, LineData> representatives = new IdentityHashMap<>();
    private IdentityHashMap<LineData, LinkedList<LineData>> clusters = new IdentityHashMap<>();

    public UnionFind(List<LineData> segments) {
        for (int i = 0; i < segments.size() - 1; i++) {
            LineData nodeA = segments.get(i);

            //Make an edge between every node.
            for (int i2 = i + 1; i2 < segments.size(); i2++) {
                LineData nodeB = segments.get(i2);

                edges.add(new Edge(nodeA, nodeB));
            }
        }
        Collections.sort(edges);

        for (LineData seg : segments) {
            //Initialize representatives list
            representatives.put(seg, seg);

            LinkedList<LineData> initialCluster = new LinkedList<>();
            initialCluster.push(seg);
            clusters.put(seg, initialCluster);
        }
    }

    @Override
    public LineData find(LineData i) {
        return representatives.get(i);
    }

    @Override
    public boolean union(Edge e) {
        LineData repForA = find(e.getA());
        LineData repForB = find(e.getB());

        if (repForA != repForB) {
            if (clusters.get(repForA).size() >= clusters.get(repForB).size()) {
                clusters.get(repForA).addAll(clusters.get(repForB));

                LinkedList<LineData> nodesForB = clusters.get(repForB);

                clusters.remove(repForB, null);

                //Update reps
                for (LineData node : nodesForB) {
                    representatives.put(node, repForA);
                }
            } else {
                clusters.get(repForB).addAll(clusters.get(repForA));

                LinkedList<LineData> nodesForA = clusters.get(repForA);

                clusters.put(repForA, null);

                //Update reps
                for (LineData node : nodesForA) {
                    representatives.put(node, repForB);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public IdentityHashMap<LineData, LineData> getRepresentatives() {
        return representatives;
    }

    public IdentityHashMap<LineData, LinkedList<LineData>> getClusters() {
        return clusters;
    }
}
