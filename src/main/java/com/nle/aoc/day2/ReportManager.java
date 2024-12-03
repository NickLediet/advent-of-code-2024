package com.nle.aoc.day2;

import java.util.Arrays;
import java.util.List;

public class ReportManager {
    public List<Report> reports;

    public ReportManager(String rawInput) {
        reports = createReportsMatrix(rawInput);
    }

    private List<Report> createReportsMatrix(String inputString) {
        return Arrays.stream(inputString.split("\n"))
                .map(Report::new)
                .toList();
    }

    public List<Report> getSafeReports() {
        return reports.stream()
                .filter(Report::validate)
                .toList();
    }
}
