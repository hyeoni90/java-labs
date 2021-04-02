package com.hyeonah.javalabs.algorithm.programmers.dynamicprogramming;

/**
 * 동적 계획법 > 정수 삼각형
 */
public class Solution43105 {

    public static void main(final String[] args) {
        final int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(new Solution43105().solution(triangle));
    }

    private int solution(final int[][] triangle) {
        int answer = 0;
        final int[][] dp = new int[triangle.length][triangle.length];

        dp[0][0] = triangle[0][0];
        // 2번째 행 부터 0번째 값과 행의 마지막 번째 값
        for (int i = 1; i < triangle.length; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        for (int i = 2; i < triangle.length; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }

        // 마지막 행의 값들 중 최대 값
        for (int i = 0; i < dp[triangle.length - 1].length; i++) {
            answer = Math.max(answer, dp[triangle.length - 1][i]);
        }

        return answer;
    }
}
