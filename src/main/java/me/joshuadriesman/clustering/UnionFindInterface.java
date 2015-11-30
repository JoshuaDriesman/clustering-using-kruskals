package me.joshuadriesman.clustering;

/**
 * Created by Joshua Driesman on 11/29/2015.
 */
public interface UnionFindInterface {
    public ImageSegment find(ImageSegment i);

    public void union(Edge e);
}
