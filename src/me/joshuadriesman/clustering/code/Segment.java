package me.joshuadriesman.clustering.code;

import java.util.Objects;

/**
 * Created by Joshua Driesman on 10/20/2015.
 *
 * Copyright 2015 Joshua Driesman, All rights reserved
 *
 * Represents a single piece of image segment data (aka a single line from the .arff file)
 */
public class Segment implements LineData{
    private final int regionCentroidCol;
    private final int regionCentroidRow;
    private final int regionPixelCount;
    private final int shortLineDensity5;
    private final int shortLineDensity2;
    private final int vedgeMean;
    private final int vedgeSd;
    private final int hedgeMean;
    private final int hedgeSd;
    private final int intensityMean;
    private final int rawredMean;
    private final int rawblueMean;
    private final int rawgreenMean;
    private final int exredMean;
    private final int exblueMean;
    private final int exgreenMean;
    private final int valueMean;
    private final int saturatoinMean;
    private final int hueMean;

    private final String label;

    /**
     * Creates a new segment object.
     * @param regionCentroidCol The segment's regionCentroidCol.
     * @param regionCentroidRow The segment's regionCentroidRow.
     * @param regionPixelCount The segment's regionPixelCount.
     * @param shortLineDensity5 The segment's shortLineDensity5.
     * @param shortLineDensity2 The segment's shortLineDensity2.
     * @param vedgeMean The segment's vedgeMean.
     * @param vedgeSd The segment's vedgeSd.
     * @param hedgeMean The segment's hedgeMean.
     * @param hedgeSd The segment's hedgeSd.
     * @param intensityMean The segment's intensityMean.
     * @param rawredMean The segment's rawredMean.
     * @param rawblueMean The segment's rawblueMean.
     * @param rawgreenMean The segment's rawgreenMean.
     * @param exredMean The segment's exredMean.
     * @param exblueMean The segment's exblueMean.
     * @param exgreenMean The segment's exgreenMean.
     * @param valueMean The segment's valueMean.
     * @param saturatoinMean The segment's saturatoinMean.
     * @param hueMean The segment's hueMean.
     * @param label The segment's label.
     */
    public Segment(int regionCentroidCol, int regionCentroidRow, int regionPixelCount, int shortLineDensity5,
                   int shortLineDensity2, int vedgeMean, int vedgeSd, int hedgeMean, int hedgeSd, int intensityMean,
                   int rawredMean, int rawblueMean, int rawgreenMean, int exredMean, int exblueMean, int exgreenMean,
                   int valueMean, int saturatoinMean, int hueMean, String label) {

        this.regionCentroidCol = regionCentroidCol;
        this.regionCentroidRow = regionCentroidRow;
        this.regionPixelCount = regionPixelCount;
        this.shortLineDensity5 = shortLineDensity5;
        this.shortLineDensity2 = shortLineDensity2;
        this.vedgeMean = vedgeMean;
        this.vedgeSd = vedgeSd;
        this.hedgeMean = hedgeMean;
        this.hedgeSd = hedgeSd;
        this.intensityMean = intensityMean;
        this.rawredMean = rawredMean;
        this.rawblueMean = rawblueMean;
        this.rawgreenMean = rawgreenMean;
        this.exredMean = exredMean;
        this.exblueMean = exblueMean;
        this.exgreenMean = exgreenMean;
        this.valueMean = valueMean;
        this.saturatoinMean = saturatoinMean;
        this.hueMean = hueMean;

        Objects.requireNonNull(label);
        this.label = label;
    }

    /**
     * Getter for regionCentroidCol
     * @return regionCentroidCol
     */
    public int getRegionCentroidCol() {
        return regionCentroidCol;
    }

    /**
     * Getter for regionCentroidRow
     * @return regionCentroidRow
     */
    public int getRegionCentroidRow() {
        return regionCentroidRow;
    }

    /**
     * Getter for regionPixelCount
     * @return regionPixelCount
     */
    public int getRegionPixelCount() {
        return regionPixelCount;
    }

    /**
     * Getter for shortLineDensity5
     * @return shortLineDensity5
     */
    public int getShortLineDensity5() {
        return shortLineDensity5;
    }

    /**
     * Getter for shortLineDensity2
     * @return shortLineDensity2
     */
    public int getShortLineDensity2() {
        return shortLineDensity2;
    }

    /**
     * Getter for vedgeMean
     * @return vedgeMean
     */
    public int getVedgeMean() {
        return vedgeMean;
    }

    /**
     * Getter for vedgeSd
     * @return vedgeSd
     */
    public int getVedgeSd() {
        return vedgeSd;
    }

    /**
     * Getter for hedgeMean
     * @return hedgeMean
     */
    public int getHedgeMean() {
        return hedgeMean;
    }

    /**
     * Getter for hedgeSd
     * @return hedgeSd
     */
    public int getHedgeSd() {
        return hedgeSd;
    }

    /**
     * Getter for intensityMean
     * @return intensityMean
     */
    public int getIntensityMean() {
        return intensityMean;
    }

    /**
     * Getter for rawredMean
     * @return rawredMean
     */
    public int getRawredMean() {
        return rawredMean;
    }

    /**
     * Getter for rawblueMean
     * @return rawblueMean
     */
    public int getRawblueMean() {
        return rawblueMean;
    }

    /**
     * Getter for rawgreenMean
     * @return rawgreenMean
     */
    public int getRawgreenMean() {
        return rawgreenMean;
    }

    /**
     * Getter for exredMean
     * @return exredMean
     */
    public int getExredMean() {
        return exredMean;
    }

    /**
     * Getter for exblueMean
     * @return exblueMean
     */
    public int getExblueMean() {
        return exblueMean;
    }

    /**
     * Getter for exgreenMean
     * @return exgreenMean
     */
    public int getExgreenMean() {
        return exgreenMean;
    }

    /**
     * Getter for valueMean
     * @return valueMean
     */
    public int getValueMean() {
        return valueMean;
    }

    /**
     * Getter for saturatoinMean
     * @return saturatoinMean
     */
    public int getSaturatoinMean() {
        return saturatoinMean;
    }

    /**
     * Getter for hueMean
     * @return hueMean
     */
    public int getHueMean() {
        return hueMean;
    }

    /**
     * Getter for label
     * @return label
     */
    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Segment segment = (Segment) o;

        if (regionCentroidCol != segment.regionCentroidCol) return false;
        if (regionCentroidRow != segment.regionCentroidRow) return false;
        if (regionPixelCount != segment.regionPixelCount) return false;
        if (shortLineDensity5 != segment.shortLineDensity5) return false;
        if (shortLineDensity2 != segment.shortLineDensity2) return false;
        if (vedgeMean != segment.vedgeMean) return false;
        if (vedgeSd != segment.vedgeSd) return false;
        if (hedgeMean != segment.hedgeMean) return false;
        if (hedgeSd != segment.hedgeSd) return false;
        if (intensityMean != segment.intensityMean) return false;
        if (rawredMean != segment.rawredMean) return false;
        if (rawblueMean != segment.rawblueMean) return false;
        if (rawgreenMean != segment.rawgreenMean) return false;
        if (exredMean != segment.exredMean) return false;
        if (exblueMean != segment.exblueMean) return false;
        if (exgreenMean != segment.exgreenMean) return false;
        if (valueMean != segment.valueMean) return false;
        if (saturatoinMean != segment.saturatoinMean) return false;
        if (hueMean != segment.hueMean) return false;
        return label.equals(segment.label);

    }

    @Override
    public int hashCode() {
        int result = regionCentroidCol;
        result = 31 * result + regionCentroidRow;
        result = 31 * result + regionPixelCount;
        result = 31 * result + shortLineDensity5;
        result = 31 * result + shortLineDensity2;
        result = 31 * result + vedgeMean;
        result = 31 * result + vedgeSd;
        result = 31 * result + hedgeMean;
        result = 31 * result + hedgeSd;
        result = 31 * result + intensityMean;
        result = 31 * result + rawredMean;
        result = 31 * result + rawblueMean;
        result = 31 * result + rawgreenMean;
        result = 31 * result + exredMean;
        result = 31 * result + exblueMean;
        result = 31 * result + exgreenMean;
        result = 31 * result + valueMean;
        result = 31 * result + saturatoinMean;
        result = 31 * result + hueMean;
        result = 31 * result + label.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Segment{" +
                "regionCentroidCol=" + regionCentroidCol +
                ", regionCentroidRow=" + regionCentroidRow +
                ", regionPixelCount=" + regionPixelCount +
                ", shortLineDensity5=" + shortLineDensity5 +
                ", shortLineDensity2=" + shortLineDensity2 +
                ", vedgeMean=" + vedgeMean +
                ", vedgeSd=" + vedgeSd +
                ", hedgeMean=" + hedgeMean +
                ", hedgeSd=" + hedgeSd +
                ", intensityMean=" + intensityMean +
                ", rawredMean=" + rawredMean +
                ", rawblueMean=" + rawblueMean +
                ", rawgreenMean=" + rawgreenMean +
                ", exredMean=" + exredMean +
                ", exblueMean=" + exblueMean +
                ", exgreenMean=" + exgreenMean +
                ", valueMean=" + valueMean +
                ", saturatoinMean=" + saturatoinMean +
                ", hueMean=" + hueMean +
                ", label='" + label + '\'' +
                '}';
    }
}
