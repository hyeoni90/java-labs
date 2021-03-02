package com.hyeonah.javalabs.algorithm.top50coding.stringAndArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyeoni90 on 2021-02-27
 */
public class MissingRanges {

    public static void main(final String[] args) {
        final int[] nums = {2,3,5,50,75};
        final int lower = 0;
        final int upper = 99;

        // 0->1, 4, 6->49, 51->74, 76->99]
        System.out.println(new MissingRanges().solution(nums, lower, upper));
    }

    private List<String> solution(final int[] nums, final int lower, final int upper) {
        // 1
        final List<String> result = new ArrayList<>();

        if(nums == null || nums.length == 0) {
            return result;
        }

        // 2
        // 0 < 2: lower < nums[0], 0 -> 1
        if(lower < nums[0]) {
            result.add(makeRange(lower, nums[0]));
        }

        // 2-2
        // 2 3 , 3 5 nums[i] + 1 < nums[i+1]
        // 2~3 인 경우 pass, 3~5 인 경우 4, 3+1 = 5-1 nums[i]+1, nums[i+1]-1
        for (int i = 0; i < nums.length - 1; i++) {
             if(nums[i] != nums[i+1] && nums[i] +1 < nums[i+1]) {
                 result.add(makeRange(nums[i] + 1, nums[i+1] - 1));
             }
        }

        // 2-3
        // 75 < 99
        if(nums[nums.length - 1] < upper) {
            result.add(makeRange(nums[nums.length -1] + 1, upper));
        }
        return result;
    }

    private String makeRange(final int lower, final int high) {
        return lower == high ? String.valueOf(lower) : String.format("%d -> %d", lower, high);
    }
}
