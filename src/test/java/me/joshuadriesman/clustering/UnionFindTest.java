package me.joshuadriesman.clustering;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Joshua Driesman on 11/30/2015.
 *
 * Copyright 2015 Joshua Driesman, All rights reserved
 */
public class UnionFindTest {
    @Test
    public void testSortingOfEdges() {
        List<LineData> imageSegments = new ArffParser("src/test/resources/segment-test.arff").parseWhole();
        UnionFind uf = new UnionFind(imageSegments);

        List<Edge> edges = uf.getEdges();

        // Make sure list of edges is sorted properly
        for (int i=0; i<edges.size() - 1; i++) {
            assertTrue(edges.get(i).getWeight() <= edges.get(i + 1).getWeight());
        }
    }

    @Test
    public void testInitialRepresentativesList() {
        List<LineData> imageSegments = new ArffParser("src/test/resources/segment-test.arff").parseWhole();
        UnionFind uf = new UnionFind(imageSegments);

        HashMap<LineData, LineData> repPairs = uf.getRepresentatives();

        for (Map.Entry<LineData, LineData> entry : repPairs.entrySet()) {
            assertEquals(entry.getKey(), (entry.getValue()));
        }
    }
}
