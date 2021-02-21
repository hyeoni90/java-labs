package com.hyeonah.javalabs.algorithm.top50coding.dynamicprogramming;

/**
 * Created by hyeonahlee on 2021-01-31.
 */
public class UniquePaths {

    public static void main(final String[] args) {
        final int m = 7;
        final int n = 3;
        System.out.println(uniquePaths(m, n));
    }

    private static int uniquePaths(final int m, final int n) {
        final Integer[][] map = new Integer[m][n];

        // 첫번째 행 1로 초기 셋팅
        for (int i = 0; i < m; i++) {
            map[i][0] = 1;
        }

        // 첫번째 열 1로 초기 셋팅
        for (int i = 0; i < n; i++) {
            map[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }

        return map[m - 1][n - 1];
    }
}
