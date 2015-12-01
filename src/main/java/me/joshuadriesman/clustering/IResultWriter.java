package me.joshuadriesman.clustering;

import java.io.IOException;

/**
 * Created by Joshua Driesman on 12/1/2015.
 *
 * Copyright 2015 Joshua Driesman, All rights reserved
 */
public interface IResultWriter {
    /**
     * Writes a line to the file.
     * @param line the line to write to the file
     * @throws java.nio.file.ClosedFileSystemException if the writer has already been closed
     * @throws java.io.IOException if the line could not be written
     */
    public void writeLine(String line) throws IOException;
}
