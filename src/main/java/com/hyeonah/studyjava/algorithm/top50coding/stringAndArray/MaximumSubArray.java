package com.hyeonah.studyjava.algorithm.top50coding.stringAndArray;

/**
 * subArray 중 합이 제일 큰 수 return
 */
public class MaximumSubArray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    private static int maxSubArray(int[] nums) {
        int newSum = nums[0];
        int max = nums[0];

        /**
         * ex) int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4}
         * 4, -1, 2, 1 << 이 구간을 찾는 것이 중요! (continuous subarray)
         */
        for (int i = 0; i < nums.length; i++) {
            newSum = Math.max(nums[i], newSum + nums[i]);
            max = Math.max(newSum, max);
        }
        return max;
    }
}
