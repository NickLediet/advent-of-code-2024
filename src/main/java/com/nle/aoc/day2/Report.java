package com.nle.aoc.day2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Report {
    enum Delta {
        INC, DEC, NONE
    }

    private ArrayList<Integer> levels = new ArrayList<Integer>();
    List<Delta> deltas = new ArrayList<Delta>();

    public Report(String reportString) {
        setLevels(reportString);
    }

    private void setLevels(String reportString) {
        String[] reportLevelStrings = reportString.split("\s");
        Arrays.stream(reportLevelStrings)
                .forEach(levelString -> levels.add(Integer.parseInt(levelString)));
    }

    private Delta getDelta(int diff) {
        if (diff < 0) {
            return Delta.INC;
        } else if (diff > 0) {
            return Delta.DEC;
        } else {
            return Delta.NONE;
        }
    }

    public List<Delta> getDeltas() {
        return deltas;
    }

    public boolean validate() {
        deltas.clear();
        boolean isValid = true;
        int curr = 0;
        // For each level: (tracked by cursor)
        while(isValid) {
            if(curr == (levels.size() - 1)) break;
            int next = curr + 1;
            // -> check if the next value has a difference between 1 or 3
            int diff = levels.get(curr) - levels.get(next);
            int absDiff = Math.abs(diff);
            // -> validate the diff is in the allowed range, if not we know the whole report is unsafe
            if(absDiff > 3 || absDiff < 1) {
                return false;
            }
            // -> record if diff between values is an increase or decrease
            deltas.add(getDelta(diff));
            curr++;
        }
        Delta firstDelta = deltas.get(0);
        for(Delta delta : deltas) {
            if(delta != firstDelta) return false;
        }

        return isValid;
    }

    @Override
    public String toString() {
       return levels.toString();
    }
}
