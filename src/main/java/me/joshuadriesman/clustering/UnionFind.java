package me.joshuadriesman.clustering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * Created by Joshua Driesman on 11/29/2015.
 *
 * Copyright 2015 Joshua Driesman, All rights reserved
 */
public class UnionFind implements UnionFindInterface{
    private HashMap<LineData, LineData> representatives;
    private ArrayList<Edge> edges  = new ArrayList<>();

    public UnionFind(ArrayList<LineData> segments) {
        for (LineData s : segments) {
            edges.addAll(segments.stream().filter(s2 -> s != s2).map(s2 -> new Edge(s, s2)).collect(Collectors.toList()));
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

    public ArrayList<Edge> getEdges() {
        return edges;
    }
}
