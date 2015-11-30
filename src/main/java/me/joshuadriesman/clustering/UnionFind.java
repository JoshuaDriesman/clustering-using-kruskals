package me.joshuadriesman.clustering;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Joshua Driesman on 11/29/2015.
 *
 * Copyright 2015 Joshua Driesman, All rights reserved
 */
public class UnionFind implements UnionFindInterface{
    private HashMap<ImageSegment, ImageSegment> representatives;

    public UnionFind(ArrayList<ImageSegment> segments) {
        for (ImageSegment s : segments) {

        }
    }

    @Override
    public ImageSegment find(ImageSegment i) {
        return null;
    }

    @Override
    public void union(Edge e) {

    }
}
