package com.nle.aoc.day2;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Arrays;

public class Part1 {
    public static String loadFile(String filename) {
        ClassLoader classLoader = Part1.class.getClassLoader();
        try(InputStream inputStream = classLoader.getResourceAsStream(filename)) {
            return new String(inputStream.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

   public static void main(String[] args) {
        String fileContents = loadFile("inputs/day2.txt");
        ReportManager reportManager = new ReportManager(fileContents);
        List<Report> safeReports = reportManager.getSafeReports();
        System.out.println(safeReports.size());
    }
}
