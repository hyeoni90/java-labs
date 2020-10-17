package com.hyeonah.studyjava.algorithm.javaCodingTop50.stringAndArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * target의 숫자를 만드는 요소의 번호 추출
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 8, 11, 21};
        int target = 10;
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.solve(nums, target)));
    }

    private int[] solve(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int  i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int valueOfMap = map.get(nums[i]); // i = 1일 때 8, map(8,0)
                result[0] = valueOfMap + 1;
                result[1] = i + 1;
            } else {
                map.put(target - nums[i], i); // key 10-2 = 8, i = 0
            }
        }

        return result;
    }
}
