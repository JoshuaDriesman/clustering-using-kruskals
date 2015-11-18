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
                    Integer.valueOf(splitLine[3]), Integer.valueOf(splitLine[4]), Integer.valueOf(splitLine[5]),
                    Integer.valueOf(splitLine[6]), Integer.valueOf(splitLine[7]), Integer.valueOf(splitLine[8]),
                    Integer.valueOf(splitLine[9]), Integer.valueOf(splitLine[10]), Integer.valueOf(splitLine[11]),
                    Integer.valueOf(splitLine[12]), Integer.valueOf(splitLine[13]), Integer.valueOf(splitLine[14]),
                    Integer.valueOf(splitLine[15]), Integer.valueOf(splitLine[16]), Integer.valueOf(splitLine[17]),
                    Integer.valueOf(splitLine[18]), Integer.valueOf(splitLine[19]), splitLine[20]);
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
