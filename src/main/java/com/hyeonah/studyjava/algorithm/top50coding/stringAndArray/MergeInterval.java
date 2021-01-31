package com.hyeonah.studyjava.algorithm.top50coding.stringAndArray;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

    public static void main(String[] args) {
        int[][] nums = {{2, 6}, {1, 3}, {8, 10}, {15, 18}};
        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            intervals.add(new Interval(nums[i][0], nums[i][1]));
        }

        List<Interval> result = new MergeInterval().merge(intervals);
        new MergeInterval().print(result);
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals.isEmpty()) {
            return intervals;
        }

        print(intervals);
        // 1. 오름차순 정렬
        intervals.sort(Comparator.comparingInt(a -> a.start));
        System.out.println("=============");

        // 2.
        Interval beforeInterval = intervals.get(0); // [1,3]
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);

            // merge => [1,6]
            if (beforeInterval.end >= current.start) {
                beforeInterval.end = Math.max(beforeInterval.end, current.end);
            } else {
                result.add(beforeInterval);
                beforeInterval = current;
            }
        }

        // 3. 맨 마지막 요소가 들어 가지 않으니, 넣어 준다!
        if (!result.contains(beforeInterval)) {
            result.add(beforeInterval);
        }

        return result;
    }

    private void print(List<Interval> intervals) {
        for (int i = 0; i < intervals.size(); i++) {
            Interval in = intervals.get(i);
            System.out.println(in.start + " " + in.end);
        }
    }
}
