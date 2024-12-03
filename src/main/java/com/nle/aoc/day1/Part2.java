package com.nle.aoc.day1;

import java.io.IOException;
import java.io.InputStream;

public class Part2 {
    public static String loadFile(String filename) {
        ClassLoader classLoader = Part2.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream("inputs/day1.txt")) {
            return new String(inputStream.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String fileContents = loadFile("day1/input.txt");
        LocationManager locationManager = new LocationManager(fileContents);
        int totalSimilarityScore = locationManager
                .buildFrequencyMap()
                .getSimilarityScores()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(totalSimilarityScore);

    }


}
