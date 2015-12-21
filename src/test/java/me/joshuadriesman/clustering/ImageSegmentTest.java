package me.joshuadriesman.clustering;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Joshua Driesman on 10/20/2015.
 *
 * Copyright 2015 Joshua Driesman
 *
 * Tests for the ImageSegment class.
 */
public class ImageSegmentTest {
    final String TEST_FILE_PATH = "src/test/resources/segment-test.arff";

    @Test
    public void imageSegmentDistanceTest() {
        Parser p = new ArffParser(TEST_FILE_PATH);

        LineData x = p.parseLine();
        LineData y = p.parseLine();

        double dist = x.distance(y);

        double expected = 187.96463529442100d;

        assertEquals(expected, dist, .000000000001d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDistanceDifferentTypes() {
        Parser p = new ArffParser(TEST_FILE_PATH);
        LineData x = p.parseLine();
        LineData fake = new FakeLineData();

        x.distance(fake);
    }

    @Test
    public void testEqualsTrue() throws Exception {
        ImageSegment i = new ImageSegment(1, 2, 3, 4d, 5d, 6d, 7d, 8d, 9d, 10d, 11d, 12d, 13d, 14d, 15d, 16d, 17d, 18d,
                19d, "a");

        ImageSegment i2 = new ImageSegment(1, 2, 3, 4d, 5d, 6d, 7d, 8d, 9d, 10d, 11d, 12d, 13d, 14d, 15d, 16d, 17d, 18d,
                19d, "a");

        assertTrue(i.equals(i2));
    }

    @Test
    public void testEqualsFalse() throws Exception {
        ImageSegment i = new ImageSegment(1, 2, 3, 4d, 5d, 6d, 7d, 8d, 9d, 10d, 11d, 12d, 13d, 14d, 15d, 16d, 17d, 18d,
                19d, "a");

        ImageSegment i2 = new ImageSegment(1, 2, 3, 44d, 5d, 6d, 7d, 8d, 9d, 10d, 11d, 12d, 13d, 14d, 15d, 16d, 17d, 18d,
                19d, "a");

        assertFalse(i.equals(i2));
    }

    @Test
    public void testHashCode() throws Exception {
        int i = new ImageSegment(1, 2, 3, 4d, 5d, 6d, 7d, 8d, 9d, 10d, 11d, 12d, 13d, 14d, 15d, 16d, 17d, 18d,
                19d, "a").hashCode();

        int i2 = new ImageSegment(1, 2, 3, 4d, 5d, 6d, 7d, 8d, 9d, 10d, 11d, 12d, 13d, 14d, 15d, 16d, 17d, 18d,
                19d, "a").hashCode();

        assertEquals(i, i2);
    }

    @Test
    public void testToString() throws Exception {
        ImageSegment i = new ImageSegment(1, 2, 3, 4d, 5d, 6d, 7d, 8d, 9d, 10d, 11d, 12d, 13d, 14d, 15d, 16d, 17d, 18d,
                19d, "a");
        String expected = "ImageSegment{" +
                    "regionCentroidCol=" + 1 +
                    ", regionCentroidRow=" + 2 +
                    ", regionPixelCount=" + 3 +
                    ", shortLineDensity5=" + 4d +
                    ", shortLineDensity2=" + 5d +
                    ", vedgeMean=" + 6d +
                    ", vedgeSd=" + 7d +
                    ", hedgeMean=" + 8d +
                    ", hedgeSd=" + 9d +
                    ", intensityMean=" + 10d +
                    ", rawredMean=" + 11d +
                    ", rawblueMean=" + 12d +
                    ", rawgreenMean=" + 13d +
                    ", exredMean=" + 14d +
                    ", exblueMean=" + 15d +
                    ", exgreenMean=" + 16d +
                    ", valueMean=" + 17d +
                    ", saturatoinMean=" + 18d +
                    ", hueMean=" + 19d +
                    ", label='" + "a" + '\'' +
                    '}';

        assertEquals(expected, i.toString());
    }

    // A blank implementation of LineData to test if ImageSegment will allow you to calculate the distance between
    // two LineData implementations of different types.
    class FakeLineData implements LineData {

        @Override
        public double distance(LineData o) {
            return 0;
        }
    }
}
