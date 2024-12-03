package com.nle.aoc.day1;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Part1 {
    public static String loadFile(String filename) {
        ClassLoader classLoader = Part1.class.getClassLoader();
        try(InputStream inputStream = classLoader.getResourceAsStream("inputs/day1.txt")) {
            return new String(inputStream.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

   public static void main(String[] args) {
        String fileContents = loadFile("day1/input.txt");
        LocationManager locationManager = new LocationManager(fileContents);
        int totalDistance = locationManager.sort().getTotalDistance();
        System.out.println(totalDistance);

    }
}
