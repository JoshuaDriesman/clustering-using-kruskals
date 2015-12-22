package me.joshuadriesman.clusteringusingkruskals;

/**
 * Created by Joshua Driesman on 11/29/2015.
 *
 * Copyright 2015 Joshua Driesman
 *
 * Represents a UnionFind structure.
 */
public interface UnionFindInterface {
    /**
     * Find the representative of the set that this LineData is in.
     * @param i the LineData who's set you want to look up
     * @return the representative of the set
     */
    LineData find(LineData i);

    /**
     * Union the two sets connected by that edge.
     * @param e the edge to add to the graph.
     * @return if the edge resulted in a merge (e.g the ends of the edge were in different clusters)
     */
    boolean union(Edge e);
}
