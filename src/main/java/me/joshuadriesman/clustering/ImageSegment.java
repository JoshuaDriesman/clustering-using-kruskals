package me.joshuadriesman.clustering;

import java.util.Objects;

/**
 * Created by Joshua Driesman on 10/20/2015.
 *
 * Copyright 2015 Joshua Driesman, All rights reserved
 *
 * Represents a single piece of image segment data (aka a single line from the .arff file)
 */
public class ImageSegment implements LineData{
    private final int regionCentroidCol;
    private final int regionCentroidRow;
    private final int regionPixelCount;
    private final double shortLineDensity5;
    private final double shortLineDensity2;
    private final double vedgeMean;
    private final double vedgeSd;
    private final double hedgeMean;
    private final double hedgeSd;
    private final double intensityMean;
    private final double rawredMean;
    private final double rawblueMean;
    private final double rawgreenMean;
    private final double exredMean;
    private final double exblueMean;
    private final double exgreenMean;
    private final double valueMean;
    private final double saturatoinMean;
    private final double hueMean;

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
    public ImageSegment(int regionCentroidCol, int regionCentroidRow, int regionPixelCount, double shortLineDensity5,
                        double shortLineDensity2, double vedgeMean, double vedgeSd, double hedgeMean, double hedgeSd,
                        double intensityMean, double rawredMean, double rawblueMean, double rawgreenMean, double exredMean,
                        double exblueMean, double exgreenMean, double valueMean, double saturatoinMean, double hueMean,
                        String label) {

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

    @Override
    public double distance(LineData o) {
        if (!(o instanceof ImageSegment)) {
            throw new IllegalArgumentException("LineData type must match in order to calculate distance.");
        }

        ImageSegment other = (ImageSegment) o;

        int regionCentroidColDist = this.regionCentroidCol - other.getRegionCentroidCol();
        int regionCentroidRowDist = this.regionCentroidRow - other.getRegionCentroidRow();
        int regionPixelCountDist = this.regionPixelCount - other.getRegionPixelCount();
        double shortLineDensity5Dist = this.shortLineDensity5 - other.getShortLineDensity5();
        double shortLineDensity2Dist = this.shortLineDensity2 - other.getShortLineDensity2();
        double vedgeMeanDist = this.vedgeMean - other.getVedgeMean();
        double vedgeSdDist = this.vedgeSd - other.getVedgeSd();
        double hedgeMeanDist = this.hedgeMean - other.getHedgeMean();
        double headgeSdDist = this.hedgeSd - other.getHedgeSd();
        double intensityMeanDist = this.intensityMean - other.getIntensityMean();
        double rawredMeanDist = this.rawredMean - other.getRawredMean();
        double rawblueMeanDist = this.rawblueMean - other.getRawblueMean();
        double rawgreenMeanDist = this.rawgreenMean - other.getRawgreenMean();
        double exredMeanDist = this.exredMean - other.getExredMean();
        double exblueMeanDist = this.exblueMean - other.getExblueMean();
        double exgreenMeanDist = this.exgreenMean - other.getExgreenMean();
        double valueMeanDist = this.valueMean - other.getValueMean();
        double saturationMeanDist = this.saturatoinMean - other.getSaturatoinMean();
        double hueMeanDist = this.hueMean - other.getHueMean();

        double distance = Math.sqrt(Math.pow(regionCentroidColDist, 2) + Math.pow(regionCentroidRowDist, 2) +
                Math.pow(regionPixelCountDist, 2) + Math.pow(shortLineDensity5Dist, 2) +
                Math.pow(shortLineDensity2Dist, 2) + Math.pow(vedgeMeanDist, 2) + Math.pow(vedgeSdDist, 2) +
                Math.pow(hedgeMeanDist, 2) + Math.pow(headgeSdDist, 2) + Math.pow(intensityMeanDist, 2) +
                Math.pow(rawredMeanDist, 2) + Math.pow(rawblueMeanDist, 2) + Math.pow(rawgreenMeanDist, 2) +
                Math.pow(exredMeanDist, 2) + Math.pow(exblueMeanDist, 2) + Math.pow(exgreenMeanDist, 2) +
                Math.pow(valueMeanDist, 2) + Math.pow(saturationMeanDist, 2) + Math.pow(hueMeanDist, 2));

        return distance;
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
    public double getShortLineDensity5() {
        return shortLineDensity5;
    }

    /**
     * Getter for shortLineDensity2
     * @return shortLineDensity2
     */
    public double getShortLineDensity2() {
        return shortLineDensity2;
    }

    /**
     * Getter for vedgeMean
     * @return vedgeMean
     */
    public double getVedgeMean() {
        return vedgeMean;
    }

    /**
     * Getter for vedgeSd
     * @return vedgeSd
     */
    public double getVedgeSd() {
        return vedgeSd;
    }

    /**
     * Getter for hedgeMean
     * @return hedgeMean
     */
    public double getHedgeMean() {
        return hedgeMean;
    }

    /**
     * Getter for hedgeSd
     * @return hedgeSd
     */
    public double getHedgeSd() {
        return hedgeSd;
    }

    /**
     * Getter for intensityMean
     * @return intensityMean
     */
    public double getIntensityMean() {
        return intensityMean;
    }

    /**
     * Getter for rawredMean
     * @return rawredMean
     */
    public double getRawredMean() {
        return rawredMean;
    }

    /**
     * Getter for rawblueMean
     * @return rawblueMean
     */
    public double getRawblueMean() {
        return rawblueMean;
    }

    /**
     * Getter for rawgreenMean
     * @return rawgreenMean
     */
    public double getRawgreenMean() {
        return rawgreenMean;
    }

    /**
     * Getter for exredMean
     * @return exredMean
     */
    public double getExredMean() {
        return exredMean;
    }

    /**
     * Getter for exblueMean
     * @return exblueMean
     */
    public double getExblueMean() {
        return exblueMean;
    }

    /**
     * Getter for exgreenMean
     * @return exgreenMean
     */
    public double getExgreenMean() {
        return exgreenMean;
    }

    /**
     * Getter for valueMean
     * @return valueMean
     */
    public double getValueMean() {
        return valueMean;
    }

    /**
     * Getter for saturatoinMean
     * @return saturatoinMean
     */
    public double getSaturatoinMean() {
        return saturatoinMean;
    }

    /**
     * Getter for hueMean
     * @return hueMean
     */
    public double getHueMean() {
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

        ImageSegment segment = (ImageSegment) o;

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
        int result;
        long temp;
        result = regionCentroidCol;
        result = 31 * result + regionCentroidRow;
        result = 31 * result + regionPixelCount;
        temp = Double.doubleToLongBits(shortLineDensity5);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(shortLineDensity2);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(vedgeMean);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(vedgeSd);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(hedgeMean);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(hedgeSd);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(intensityMean);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(rawredMean);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(rawblueMean);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(rawgreenMean);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(exredMean);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(exblueMean);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(exgreenMean);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(valueMean);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(saturatoinMean);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(hueMean);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + label.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ImageSegment{" +
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
