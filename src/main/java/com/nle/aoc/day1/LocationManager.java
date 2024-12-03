package com.nle.aoc.day1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class LocationManager {
    private ArrayList<Integer> leftLocations = new ArrayList<>();
    private ArrayList<Integer> rightLocations = new ArrayList<>();
    // For pPart 1
    private ArrayList<Integer> locationDistances = new ArrayList<>();
    // For Part 2
    private HashMap<Integer, Integer> frequencies = new HashMap<>();

    public LocationManager(String rawInputString) {
        generateLocationLists(rawInputString);
    }

    // General
    private void generateLocationLists(String rawIntputString) {
        String[] rows = rawIntputString.split("\n");
        for(String row : rows) {
            String[] locations = row.split("\s+");
            leftLocations.add(Integer.parseInt(locations[0]));
            rightLocations.add(Integer.parseInt(locations[1]));
        }
    }

    // For Part 1
    public ArrayList<Integer> getDistances() {
        if(!locationDistances.isEmpty()) {
            return locationDistances;
        }

        for(int i = 0; i < leftLocations.size(); i++) {
            Integer distance = Math.abs(rightLocations.get(i) - leftLocations.get(i));
            locationDistances.add(distance);
        }

        return locationDistances;
    }

    // For Part 1
    public Integer getTotalDistance() {
        return getDistances().stream().mapToInt(Integer::intValue).sum();
    }

    // For Part 1
    public LocationManager sort() {
        Comparator<Integer> integerComparator = (Integer a, Integer b) -> b - a > 0 ? -1 : 1;
        leftLocations.sort(integerComparator);
        rightLocations.sort(integerComparator);

        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> distances = getDistances();

        for(int i = 0; i < leftLocations.size(); i++) {
            sb
                .append(leftLocations.get(i))
                .append("\s-\s")
                .append(rightLocations.get(i))
                .append("\s=\sdistance of " + distances.get(i) + "\n");
        }

        return sb.toString();
    }

    // Part 2
    public LocationManager buildFrequencyMap() {
       for(Integer value: rightLocations) {
           if(!frequencies.containsKey(value)) {
               frequencies.put(value, 1);
               continue;
           }
           frequencies.put(value, frequencies.get(value) + 1);
       }
       return this;
    }

    // Part 2
    public ArrayList<Integer> getSimilarityScores() {
        ArrayList<Integer> similarityScores = new ArrayList<>();
        for(Integer value: leftLocations) {
            if(!frequencies.containsKey(value)) {
                similarityScores.add(0);
                continue;
            }

            similarityScores.add(value * frequencies.get(value));
        }

        return similarityScores;
    }
}
