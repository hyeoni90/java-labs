package com.hyeonah.studyjava.algorithm.javaCodingTop50.stringAndArray;

import java.util.ArrayList;
import java.util.List;

/**
 * 나사 모양으로 2차원 배열 출력 하는 문제!
 * {1, 2, 3}
 * {4, 5, 6}
 * {7, 8, 9}
 *
 * output: {1,2,3,6,9,8,7,4,5}
 *
 * hint) 규칙 찾기!!
 * [rowStart][colEnd]
 * {00, 01, 02, 03}
 * {10, 01, 02, 03}
 * {20, 21, 22, 23}
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        System.out.println(solution(matrix));
    }

    private static List<Integer> solution(int[][] matrix) {
        // 1
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        // 2
        while (rowStart <= rowEnd && colStart <= colEnd) {
            // right
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;

            // down
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            // left
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }

            // up
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    result.add(matrix[rowEnd][colStart]);
                }
                colStart++;
            }
        }
        return result;
    }
}
