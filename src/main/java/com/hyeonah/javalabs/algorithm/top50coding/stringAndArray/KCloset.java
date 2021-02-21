package com.hyeonah.javalabs.algorithm.top50coding.stringAndArray;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * keyword: PriorityQueue
 */
public class KCloset {

    public static void main(final String[] args) {
        final int[][] result = new KCloset().solution(new int[][]{{1,3},{-2,2}}, 1);
        new KCloset().print(result); // [[-2,2]]
    }

    private int[][] solution(final int[][] points, final int K) {
        /**
         * (0,0)(1,3) 거리가 1+9 = 10 sqrt(10)
         * (0,0)(-2,2) 거리가 4+4 = 8 sqrt(8)
         */
        // 1. Comparator 사용
        // Queue<int[]> queue = new PriorityQueue<>(points.length, Comp);

        // 2. lambda 표현
        final Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] * a[0] + a[1] + a[1]) - (b[0] * b[0] + b[1] * b[1]));

        final int[][] result = new int[K][2];
        int index = 0;

        for (final int[] p : points) {
            queue.offer(p);
        }

        while (index < K) {
            result[index] = queue.poll();
            index++;
        }

        return result;
    }

    private void print(final int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.println(result[i][j]);
            }
        }
    }

    Comparator<int[]> Comp = new Comparator<int[]>() {
        @Override
        public int compare(final int[] a, final int[] b) {
            // 오름차순
            return (a[0] * a[0] + a[1] + a[1]) - (b[0] * b[0] + b[1] * b[1]);
        }
    };
}
