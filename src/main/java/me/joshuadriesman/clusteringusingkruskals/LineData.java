package me.joshuadriesman.clusteringusingkruskals;

/**
 * Created by Joshua Driesman on 10/20/2015.
 *
 * Copyright 2015 Joshua Driesman
 *
 * Interface for an object that represents single line from a data format file. (e.g .arff file)
 */
public interface LineData {
    /**
     * Calculates the clusteringusingkruskals distance between the current piece of data and the other piece of data.
     * @param o the data for the node to calculate the distance to.
     * @return the distance between the two nodes
     */
    public double distance(LineData o);
}
