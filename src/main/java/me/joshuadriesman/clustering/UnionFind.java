package me.joshuadriesman.clustering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Joshua Driesman on 11/29/2015.
 *
 * Copyright 2015 Joshua Driesman, All rights reserved
 */
public class UnionFind implements UnionFindInterface{
    private List<Edge> edges  = new ArrayList<>();
    private HashMap<LineData, LineData> representatives;

    public UnionFind(List<LineData> segments) {
        for (int i = 0; i < segments.size() - 1; i++) {
            LineData nodeA = segments.get(i);
            for (int i2 = i + 1; i2 < segments.size(); i2++) {
                LineData nodeB = segments.get(i2);

                edges.add(new Edge(nodeA, nodeB));
            }
        }
        Collections.sort(edges);
    }

    @Override
    public LineData find(LineData i) {
        return null;
    }

    @Override
    public void union(Edge e) {

    }

    public List<Edge> getEdges() {
        return edges;
    }
}
