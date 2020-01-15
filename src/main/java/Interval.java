import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Interval {
    public static void main(String[] args) {
        //this is pure java without any eternal dependencies like logging or lombok.
        //it can be run without any priori perpetration

        Interval interval1 = new Interval(1, 2);//1-2
        Interval interval2 = new Interval(3, 5);//3--
        Interval interval3 = new Interval(4, 8);
        Interval interval4 = new Interval(8, 12);//--12
        Interval interval5 = new Interval(13, 25);//13--
        Interval interval6 = new Interval(16, 100);//--100
        Interval interval7 = new Interval(4, 8);
        Interval interval8 = new Interval(3, 5);
        List<Interval> testList = new ArrayList<>();

        testList.add(interval1);
        testList.add(interval2);
        testList.add(interval3);
        testList.add(interval4);
        testList.add(interval5);
        testList.add(interval6);
        testList.add(interval8);
        testList.add(interval7);
        System.out.println(mergeIntervals(testList));
        //divide and conquer nlog(n) computation complexity
    }

    private int start;
    private int end;

    public Interval(int i, int j) {
        if (i < j) {
            this.start = i;
            this.end = j;
        } else {
            throw new CustomIntervalException("Start cannot be grater then end");
        }
    }

    public String toString() {
        return "[" + start + "," + end + "]";
    }

    public boolean contain(int i) {
        return (i >= this.start && i <= this.end) ? true : false;
    }

    public Interval add(Interval otherInterval, boolean allowed) {
        if (allowed) {
            this.start = min(this.start, otherInterval.start);
            this.end = max(this.end, otherInterval.end);
            return this;
        } else {
            throw new CustomIntervalException("Intervals cannot be merged");//add to string
        }
    }

    public static boolean isMergeTwoIntervalsAllowed(Interval firstInterval, Interval secondInterval) {
        return (firstInterval.contain(secondInterval.start) ||
                secondInterval.contain(firstInterval.start)) ? true : false;
    }

    public static List<Interval> mergeIntervals(List<Interval> initialList) {
        int n = initialList.size();
        if (n < 2) {
            return initialList;
        }
        List<Interval> leftList = initialList.subList(0, n / 2);
        List<Interval> rightList = initialList.subList(n / 2, n);

        List<Interval> mergedLeftList = mergeIntervals(leftList);
        List<Interval> mergedRightList = mergeIntervals(rightList);

        return mergeDivideConquerIntervals(mergedLeftList, mergedRightList);
    }

    private static List<Interval> mergeDivideConquerIntervals(List<Interval> leftList, List<Interval> rightList) {
        //try to add item from the left list to  the right list, if not possible add to final list
        List<Interval> mergedList = new ArrayList<>();
        boolean merged;

        for (Interval leftInterval : leftList) {
            merged = false;
            for (Interval rightInterval : rightList) {
                if (isMergeTwoIntervalsAllowed(leftInterval, rightInterval)) {
                    rightInterval.add(leftInterval, true);
                    merged = true;
                    break;
                }
            }
            if (!merged) mergedList.add(leftInterval);
        }
        mergedList.addAll(mergeIntervals(rightList));
        return mergedList;
    }

    public static class CustomIntervalException extends RuntimeException {
        public CustomIntervalException(String errorMessage) {
            super(errorMessage);
        }
    }
}
