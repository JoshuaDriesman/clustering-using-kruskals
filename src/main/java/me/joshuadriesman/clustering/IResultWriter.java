package me.joshuadriesman.clustering;

/**
 * Created by Joshua Driesman on 12/1/2015.
 *
 * Copyright 2015 Joshua Driesman, All rights reserved
 */
public interface IResultWriter {
    public void writeLine(String line);

    public void close(String line);

    public boolean closed();
}
