package me.joshuadriesman.clusteringusingkruskals;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Joshua Driesman on 12/1/2015.
 *
 * Copyright 2015 Joshua Driesman
 *
 * Writer for writing basic result information out to a file.
 */
public class ResultWriter implements IResultWriter, Closeable {
    private Writer writer;
    private boolean open;

    public ResultWriter(String fileToWrite, boolean overWrite) throws IOException, IllegalStateException {
        if (Files.exists(Paths.get(fileToWrite)) && overWrite) {
            Files.delete(Paths.get(fileToWrite));
        } else if (Files.exists(Paths.get(fileToWrite))) {
            throw new IllegalStateException("File already exists and overWrite is set to false.");
        }

        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileToWrite), "utf-8"));
        open = true;
    }

    @Override
    public void writeLine(String line) throws IOException {
        if (open) {
            writer.write(line + "\n");
        } else {
            throw new IllegalStateException("ResultWriter is not open");
        }
    }

    @Override
    public void write(String text) throws IOException {
        if (open) {
            writer.write(text);
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
