package me.joshuadriesman.clustering.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by Joshua Driesman on 10/20/2015.
 *
 * Copyright 2015 Joshua Driesman, All rights reserved
 */
public abstract class ParserAbstract implements Parser{
    BufferedReader reader = null;

    public ParserAbstract(String fileToParse) {
        try {
            reader = Files.newBufferedReader(Paths.get(fileToParse));
        } catch (IOException e) {
            throw new IllegalArgumentException("File does not exist or is inaccessible.");
        }
    }

    @Override
    public abstract ArrayList<LineData> parseWhole();

    @Override
    public abstract LineData parseLine();

    @Override
    public abstract boolean endOfFile();
}
