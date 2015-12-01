package me.joshuadriesman.clustering;

import java.io.*;
import java.nio.channels.IllegalSelectorException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Joshua Driesman on 12/1/2015.
 *
 * Copyright 2015 Joshua Driesman, All rights reserved
 */
public class ResultWriter implements IResultWriter, Closeable {
    private Writer writer;
    private boolean open;

    public ResultWriter(String fileToWrite, boolean overWrite) throws IOException, IllegalStateException {
        if (Files.exists(Paths.get(fileToWrite)) && overWrite) {
            Files.delete(Paths.get(fileToWrite));
        } else {
            throw new IllegalStateException("File already exists and overWrite is set to false.");
        }

        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileToWrite), "utf-8"));
        open = true;
    }

    @Override
    public void writeLine(String line) throws IOException {
        if (open) {
            writer.write(line);
        } else {
            throw new IllegalStateException("ResultWriter is not open");
        }
    }

    @Override
    public void close() throws IOException {
        writer.close();
        open = false;
    }
}
