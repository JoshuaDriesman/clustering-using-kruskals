package me.joshuadriesman.clustering;

import java.util.Objects;

/**
 * Created by Joshua Driesman on 11/30/2015.
 *
 * Copyright 2015 Joshua Driesman
 *
 * Represents an edge between two LineData nodes.
 */
final public class Edge implements Comparable {
    private final LineData a;
    private final LineData b;
    private final double weight;

    /**
     * Creates new edge object.
     * @param a the first node in the edge
     * @param b the other node in the edge
     */
    public Edge(LineData a, LineData b) {
        Objects.requireNonNull(a);
        Objects.requireNonNull(b);

        if (a == b) {
            throw new IllegalArgumentException("Can not create edge between a node and itself.");
        }

        this.a = a;
        this.b = b;

        weight = a.distance(b);
    }

    /**
     * Gets the first node in the edge
     * @return the first node in the edge
     */
    public LineData getA() {
        return a;
    }

    /**
     * Gets the other node in the edge.
     * @return the other node in the edge
     */
    public LineData getB() {
        return b;
    }

    /**
     * Gets the weight of the edge (aka the distance between the two nodes).
     * @return the weight of the edge
     */
    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Object o) {
        Objects.requireNonNull(o);

        if (!(o instanceof Edge)) {
            throw new IllegalArgumentException("Must compare against an object of the Edge type.");
        }

        Edge other = (Edge) o;

        if (other.getWeight() < this.weight) {
            return 1;
        } else if (other.getWeight() > this.weight) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Edge{" +
                "a=" + a +
                ", b=" + b +
                ", weight=" + weight +
                '}';
    }
}
