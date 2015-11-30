package me.joshuadriesman.clustering;

/**
 * Created by Joshua Driesman on 11/29/2015.
 */
public interface UnionFindInterface {
    /**
     * Find the representative of the set that this ImageSegment is in.
     * @param i the ImageSegment who's set you want to look up
     * @return the representative of the set
     */
    ImageSegment find(ImageSegment i);

    /**
     * Union the two sets connected by that edge.
     * @param e the edge to add to the graph.
     */
    void union(Edge e);
}
