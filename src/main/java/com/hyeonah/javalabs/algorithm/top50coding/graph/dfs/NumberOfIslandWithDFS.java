package com.hyeonah.javalabs.algorithm.top50coding.graph.dfs;

/**
 * Created by hyeonahlee on 2020-12-19.
 *
 * DFS > Stack
 */
public class NumberOfIslandWithDFS {

    public static void main(final String[] args) {
        final char[][] grid = {
            {'1', '1', '1', '0', '1'},
            {'1', '1', '1', '0', '0'},
            {'1', '1', '0', '0', '1'},
            {'0', '0', '0', '0', '1'}
        };

        final NumberOfIslandWithDFS numberOfIslandWithdfs = new NumberOfIslandWithDFS();
        numberOfIslandWithdfs.solution(grid);
    }

    private int solution(final char[][] grid) {
        print(grid);

        // 1. validate grid
        if (grid == null || grid[0].length == 0) {
            return 0;
        }

        // 2. [0][0] 위치에서 1인 것부터 탐색
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    System.out.print("[" + i + "][" + j + "] " + grid[i][j] +" ");
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        System.out.println("\n======result======");
        print(grid);
        return count;
    }

    public void dfs(final char[][] grid, final int i, final int j) {
//        System.out.println("i: " + i + "j: " + j);
        final int m = grid.length;
        final int n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
            return;
        }

        // 1인 애들을 다 X로 바꿔 버린다
        grid[i][j] = 'X';

        // 사방을 dfs 한다!
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public void print(final char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}
