package me.joshuadriesman.clusteringusingkruskals;

import java.io.IOException;

/**
 * Created by Joshua Driesman on 12/1/2015.
 *
 * Copyright 2015 Joshua Driesman
 *
 * Interface for writing lines to result file
 */
public interface IResultWriter {
    /**
     * Writes a line to the file.
     * @param line the line to write to the file
     * @throws IllegalStateException if the writer has already been closed
     * @throws java.io.IOException if the line could not be written
     */
    void writeLine(String line) throws IOException;

    /**
     * Writes just text to file without new line.
     * @param text text to write.
     * @throws IOException if the text could not be written
     * @throws IllegalStateException
     */
    void write(String text) throws IOException;
}
