package me.joshuadriesman.clustering;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Joshua Driesman on 11/30/2015.
 * <p>
 * Copyright 2015 Joshua Driesman
 */
public class UnionFindTest {
    final String TEST_FILE_PATH = "src/test/resources/segment-test.arff";

    @Test
    public void testSortingOfEdges() {
        List<LineData> imageSegments = new ArffParser(TEST_FILE_PATH).parseWhole();
        UnionFind uf = new UnionFind(imageSegments);

        List<Edge> edges = new ArrayList<>(uf.getEdges());

        // Make sure list of edges is sorted properly
        for (int i = 0; i < edges.size() - 1; i++) {
            assertTrue(edges.get(i).getWeight() <= edges.get(i + 1).getWeight());
        }
    }

    @Test
    public void testInitialRepresentativesList() {
        List<LineData> imageSegments = new ArffParser(TEST_FILE_PATH).parseWhole();
        UnionFind uf = new UnionFind(imageSegments);

        IdentityHashMap<LineData, LineData> repPairs = uf.getRepresentatives();

        for (Map.Entry<LineData, LineData> entry : repPairs.entrySet()) {
            assertEquals(entry.getKey(), (entry.getValue()));
        }
    }

    @Test
    public void testInitialClustersList() {
        List<LineData> imageSegments = new ArffParser(TEST_FILE_PATH).parseWhole();
        UnionFind uf = new UnionFind(imageSegments);

        IdentityHashMap<LineData, LinkedList<LineData>> clusters = uf.getClusters();

        for (Map.Entry<LineData, LinkedList<LineData>> cluster : clusters.entrySet()) {
            LineData rep = cluster.getKey();
            LinkedList<LineData> members = cluster.getValue();

            assertEquals(members.size(), 1);

            assertEquals(rep, members.pop());
        }
    }

    @Test
    public void testFindInitialReps() {
        List<LineData> imageSegments = new ArffParser(TEST_FILE_PATH).parseWhole();
        UnionFind uf = new UnionFind(imageSegments);

        LineData node = imageSegments.get(3);
        assertEquals(node, uf.find(node));
    }

    @Test
    public void testInitialUnion() {
        List<LineData> imageSegments = new ArffParser(TEST_FILE_PATH).parseWhole();
        UnionFind uf = new UnionFind(imageSegments);

        Edge e = uf.getEdges().get(0);

        uf.union(e);

        assertEquals(uf.find(e.getA()), uf.find(e.getB()));
    }
}
