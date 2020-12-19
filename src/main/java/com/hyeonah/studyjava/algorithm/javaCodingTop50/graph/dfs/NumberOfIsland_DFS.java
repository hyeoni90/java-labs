package com.hyeonah.studyjava.algorithm.javaCodingTop50.graph.dfs;

/**
 * Created by hyeonahlee on 2020-12-19.
 *
 * DFS > Stack
 */
public class NumberOfIsland_DFS {

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '1', '0', '1'},
            {'1', '1', '1', '0', '0'},
            {'1', '1', '0', '0', '1'},
            {'0', '0', '0', '0', '1'}
        };

        NumberOfIsland_DFS numberOfIsland_dfs = new NumberOfIsland_DFS();
        numberOfIsland_dfs.solution(grid);
    }

    private int solution(char[][] grid) {
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

    public void dfs(char[][] grid, int i, int j) {
//        System.out.println("i: " + i + "j: " + j);
        int m = grid.length;
        int n = grid[0].length;

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

    public void print(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}
