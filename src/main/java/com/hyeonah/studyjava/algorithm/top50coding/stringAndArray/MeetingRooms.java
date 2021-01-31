package com.hyeonah.studyjava.algorithm.top50coding.stringAndArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

class Interval {
    int start;
    int end;

    Interval() {
        this.start = 0;
        this.end = 0;
    }

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MeetingRooms {

    public static void main(String[] args) {
        MeetingRooms meetingRooms = new MeetingRooms();

        // TODO: 2020/10/11 input: [[15, 20], [5, 10], [0, 30]] 
        Interval interval1 = new Interval(15, 20);
        Interval interval2 = new Interval(5, 10);
        Interval interval3 = new Interval(0, 30);

        Interval[] intervals = {interval1, interval2, interval3};

        // TODO: 2020/10/11 output: true (T/F)
        System.out.println(meetingRooms.solve(intervals));
    }

    public boolean solve(Interval[] intervals) {

        if(Objects.isNull(intervals)) {
            return false;
        }

        // 15, 5, 0
        print(intervals);
        // 1. sorting
        Arrays.sort(intervals, comp);

        System.out.println("============");
        // 0, 5, 15
        print(intervals);

        // 2.
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i-1].end > intervals[i].end) {
                return false;
            }
        }
        return true;
    }

//    Comparator<Interval> comp = new Comparator<Interval>() {
//        @Override
//        public int compare(Interval o1, Interval o2) {
//            return o1.start - o2.start;
//        }
//    };
    // lambda 식으로 바꿈
    Comparator<Interval> comp = Comparator.comparingInt(o -> o.start);

    public void print(Interval[] intervals) {
        for (Interval interval : intervals) {
            System.out.println(interval.start + " " + interval.end);
        }
    }
}
