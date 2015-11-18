package me.joshuadriesman.clustering.code;

import java.io.IOException;
import java.util.ArrayList;

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
    }

    @Override
    public ArrayList<LineData> parseWhole() {
        return null;
    }

    @Override
    public LineData parseLine() {
        return null;
    }

    @Override
    public boolean endOfFile() {
        try {
            return !reader.ready();
        } catch (IOException e) {
            return true;
        }
    }
}
