package me.joshuadriesman.clusteringusingkruskals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

/**
 * Created by Joshua Driesman on 12/1/2015.
 *
 * Copyright 2015 Joshua Driesman
 */
public class ResultWriterTest {
    Path tempFileLocation;

    @Before
    public void setUp() throws Exception {
        tempFileLocation = Files.createTempFile(Paths.get("src/test/resources"),
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

    @Test(expected = IllegalStateException.class)
    public void testWriteAfterClose() throws Exception {
        ResultWriter writer = new ResultWriter(tempFileLocation.toString(), true);

        writer.close();
        writer.writeLine("Test");
    }

    @After
    public void breakDown() throws Exception {
        Files.delete(tempFileLocation);
    }
}
