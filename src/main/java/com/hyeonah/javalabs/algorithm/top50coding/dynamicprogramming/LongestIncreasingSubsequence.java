package com.hyeonah.javalabs.algorithm.top50coding.dynamicprogramming;

import java.util.Arrays;

/**
 * should run in O(n2) complexity
 * O(n2) > for 문 2개
 *
 * 1. 연속적으로 증가하는 것만 선택한다.
 * 2. 증가되고 있는 마지막 부분이 다음부분에 이용되어야 한다.
 * 3. 증가되고 있는 부분을 따로 저장할 것 (비교해서 max)
 */
public class LongestIncreasingSubsequence {
    public static void main(final String[] args) {
        final int[] nums = {1, 2, 3, 2, 5, 2, 6, 10, 4, 12};
//        final int[] nums2 = {9, 11, 2, 8, 4, 7, 88, 15};
        System.out.println(new LongestIncreasingSubsequence().solution(nums));
//        System.out.println(new LongestIncreasingSubsequence().solution(nums2));
    }

    private int solution(final int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        final int[] dp = new int[nums.length];
        // 1로 초기화
        Arrays.fill(dp, 1);

        int answer = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}
