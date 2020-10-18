package com.hyeonah.studyjava.algorithm.javaCodingTop50.stringAndArray;

import java.util.Arrays;
import java.util.Stack;

/**
 * hint: Stack
 */
public class DailyTemperature {

    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperature(nums);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] dailyTemperature(int[] nums) {
        // NOTE:: stack에 nums의 index와 온도 차에 따른 index를 넣는다!
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                // res[0] = 1 - 0
                int index = stack.pop();
                res[index] = i - index;
            }

            stack.push(i);
        }
        return res;
    }
}
