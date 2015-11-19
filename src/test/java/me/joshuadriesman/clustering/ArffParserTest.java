package me.joshuadriesman.clustering;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Joshua Driesman on 11/18/2015.
 */
public class ArffParserTest {
    final String TEST_FILE_PATH = "src/test/resources/segment-test.arff";

    @Test
    public void parserCreation() {
        Parser p = new ArffParser(TEST_FILE_PATH);
        assertNotNull(p);
    }

    @Test
    public void testReadLine() {
        Parser p = new ArffParser(TEST_FILE_PATH);

        LineData expected = new Segment(218, 178, 9, 0.111111, 0, 0.833333, 0.547722, 1.11111, 0.544331, 59.6296,
                52.4444, 75.2222, 51.2222, -21.5556, 46.7778, -25.2222, 75.2222, 0.318996, -2.04055, "path");
        LineData actual = p.parseLine();

        assertEquals(expected, actual);
    }

    @Test
    public void testRead2Lines() {
        Parser p = new ArffParser(TEST_FILE_PATH);

        LineData expectedLine1 = new Segment(218, 178, 9, 0.111111, 0, 0.833333, 0.547722, 1.11111, 0.544331, 59.6296,
                52.4444, 75.2222, 51.2222, -21.5556, 46.7778, -25.2222, 75.2222, 0.318996, -2.04055, "path");
        LineData expectedLine2 = new Segment(113,130,9,0,0,0.277778,0.250924,0.333333,0.365148,0.888889,0,2.55556,
                0.111111,-2.66667,5,-2.33333,2.55556,1,-2.12325,"foliage");

        LineData actualLine1 = p.parseLine();
        LineData actualLine2 = p.parseLine();

        assertEquals(expectedLine1, actualLine1);
        assertEquals(expectedLine2, actualLine2);
    }

    @Test(expected = IllegalStateException.class)
    public void testReadLinesPastEndOfFile() {
        Parser p = new ArffParser(TEST_FILE_PATH);

        for (int i = 0; i < 60; i++) {
            p.parseLine();
        }
    }

    @Test(expected = IllegalStateException.class)
    public void readWholeAfterEndOfFile() {
        Parser p = new ArffParser(TEST_FILE_PATH);

        for (int i = 0; i < 59; i++) {
            p.parseLine();
        }

        p.parseWhole();
    }
}
