package me.joshuadriesman.clustering;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

/**
 * Created by Joshua Driesman on 12/1/2015.
 *
 * Copyright 2015 Joshua Driesman, All rights reserved
 */
public class ResultWriterTest {
    Path tempFileLocation;

    @Before
    public void setUp() throws Exception {
        tempFileLocation = Files.createTempFile(Paths.get(System.getProperty("java.io.tmpdir")),
                "resultWriter", "Test");
    }

    @Test
    public void testWriteToFile() throws Exception {
        ResultWriter writer = new ResultWriter(tempFileLocation.toString(), true);

        writer.writeLine("Test");
        writer.close();

        BufferedReader reader = Files.newBufferedReader(tempFileLocation);
        assertEquals("Test", reader.readLine());
    }
}
