package com.hyeonah.javalabs.algorithm.programmers.sort;

import java.util.Arrays;

/**
 * 정렬 > K 번째 수
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 */
public class Solution42748 {

    public static void main(final String[] args) {
        final int[] array = {1, 5, 2, 6, 3, 7, 4};
        final int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        final int[] resArray = solution(array, commands);
        for (final int res : resArray) {
            System.out.print(res + " ");
        }
    }

    public static int[] solution(final int[] array, final int[][] commands) {

        final int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            final int[] subArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(subArray);
            answer[i] = subArray[(commands[i][2]) - 1];
        }
        return answer;
    }
}
