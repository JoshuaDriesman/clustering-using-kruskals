package me.joshuadriesman.clustering.code;

import java.util.List;

/**
 * Created by Joshua Driesman on 10/20/2015.
 *
 * Copyright 2015 Joshua Driesman, All rights reserved
 *
 * Interface for a basic parser.
 */
public interface Parser {
    /**
     * Parses entire file at once.
     * @return ArrayList of all the data lines in the data file.
     */
    public List<LineData> parseWhole();

    /**
     * Parses a single line in the file. Called multiple times until end of file.
     * @return the next data line in the file.
     * @throws IllegalStateException when you have reached the end of the file.
     */
    public LineData parseLine();

    /**
     * Checks to see if the end of the file has been reached.
     * @return if the parsers is at the end of the file.
     */
    public boolean endOfFile();
}
