package com.hyeonah.javalabs.algorithm.top50coding.graph;

/**
 * Created by hyeonahlee on 2020-12-20.
 */
public class MaxOfIsland {

    public static void main(final String[] args) {
        final int[][] grid = {
            {1, 1, 0, 1, 1},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 0, 1, 1},
            {1, 0, 1, 1, 1},
            {1, 0, 1, 1, 1}
        };

        System.out.println(new MaxOfIsland().maxAreaOfIslandSolution(grid));
    }

    private int maxAreaOfIslandSolution(final int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        // 초기화 셋팅
        final int m = grid.length;
        final int n = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {

                    // 1. Number of island 섬의 개수를 구한다.
                    final int area = dfs(grid, i, j, 0);

                    // 2. maxArea 4, 2, 4, 8
                    //   Math.max(max, area)
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int dfs(final int[][] grid, final int x, final int y, int area) {
        // 상 하 좌 우
        final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // 1. validate area
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return area;
        }

        // 2. 1인 육지가 들어올 경
        grid[x][y] = 0;
        area++;
        for (final int[] dir : directions) {
            area = dfs(grid, x + dir[0], y + dir[1], area);
        }
        return area;
    }
}
