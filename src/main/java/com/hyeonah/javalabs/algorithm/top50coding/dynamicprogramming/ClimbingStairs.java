package com.hyeonah.javalabs.algorithm.top50coding.dynamicprogramming;

/**
 * n 계단 오르는 방법
 *
 * point) 점화식 패턴 파
 * 0 1 2 3 4 5 6
 * 0 1 2 3 5 8 13 .. => dp[i] = dp[i-1] + dp[i-2]
 */
public class ClimbingStairs {

    public static void main(final String[] args) {
        System.out.println(new ClimbingStairs().solution(5));
    }

    private int solution(final int n) {
        final int[] dp = new int[n + 1];

        if(n == 1) {
            return 1;
        }

        if(n == 2) {
            return 2;
        }

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
