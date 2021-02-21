package com.hyeonah.javalabs.algorithm.top50coding.stringAndArray;

import java.util.HashMap;
import java.util.Map;

/**
 * 값이 같지만 순서가 다른 2개의 배열 위치를 찾는 문제!
 */
public class FindAnagramsMapping {

    public static void main(final String[] args) {
        final int[] A = {11, 27, 45, 31, 50};
        final int[] B = {50, 11, 31, 45, 27};

        final int[] result = anagramMapping(A, B);

        // A배열을 기준으로, output: [1 4 3 2 0]
        print(result);
    }

    private static int[] anagramMapping(final int[] A, final int[] B) {
        final int[] result = new int[A.length];
        final Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            map.put(B[i], i); // 1,4,3,2,0
        }

        for (int i = 0; i < A.length; i++) {
            result[i] = map.get(A[i]);  // 1 4 3 2 0
        }

        return result;
    }

    private static void print(final int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
