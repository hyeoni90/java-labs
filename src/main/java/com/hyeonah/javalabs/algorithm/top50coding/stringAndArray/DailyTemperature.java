package com.hyeonah.javalabs.algorithm.top50coding.stringAndArray;

import java.util.Stack;

/**
 * hint: Stack
 */
public class DailyTemperature {

    public static void main(final String[] args) {
        final int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        final int[] result = dailyTemperature(nums);

        for (final int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] dailyTemperature(final int[] nums) {
        // NOTE:: stack에 nums의 index와 온도 차에 따른 index를 넣는다!
        final Stack<Integer> stack = new Stack<>();
        final int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                // res[0] = 1 - 0
                final int index = stack.pop();
                res[index] = i - index;
            }

            stack.push(i);
        }
        return res;
    }
}
