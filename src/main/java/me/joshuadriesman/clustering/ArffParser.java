package me.joshuadriesman.clustering;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joshua Driesman on 10/20/2015.
 *
 * Copyright 2015 Joshua Driesman, All rights reserved
 *
 * Parser for .arrf files.
 */
public class ArffParser extends ParserAbstract {

    public ArffParser(String fileLocation) {
        super(fileLocation);
        movePastHeader();
    }

    @Override
    public List<LineData> parseWhole() {
        List<LineData> result = new ArrayList<>();

        while (!endOfFile()) {
            result.add(parseLine());
        }

        return result;
    }

    @Override
    public LineData parseLine() {
        if (!endOfFile()) {
            String line;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new IllegalStateException("Could not read file, check if it is accessible");
            }

            String[] splitLine = line.split(",");

            return new Segment(Integer.valueOf(splitLine[0]), Integer.valueOf(splitLine[1]),
                    Integer.valueOf(splitLine[2]), Double.valueOf(splitLine[3]), Double.valueOf(splitLine[4]),
                    Double.valueOf(splitLine[5]), Double.valueOf(splitLine[6]), Double.valueOf(splitLine[7]),
                    Double.valueOf(splitLine[8]), Double.valueOf(splitLine[9]), Double.valueOf(splitLine[10]),
                    Double.valueOf(splitLine[11]), Double.valueOf(splitLine[12]), Double.valueOf(splitLine[13]),
                    Double.valueOf(splitLine[14]), Double.valueOf(splitLine[15]), Double.valueOf(splitLine[16]),
                    Double.valueOf(splitLine[17]), Double.valueOf(splitLine[18]), splitLine[19]);
        } else {
            throw new IllegalStateException("End of file reached!");
        }
    }

    @Override
    public boolean endOfFile() {
        try {
            return !reader.ready();
        } catch (IOException e) {
            return true;
        }
    }

    private void movePastHeader() {
        String line = "";

        while (!line.equals("@data")) {
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new IllegalStateException("Could not read file: " + e.getMessage());
            }
        }
    }
}
