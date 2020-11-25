package com.hyeonah.studyjava.algorithm.javaCodingTop50.stringAndArray;

import java.util.HashMap;
import java.util.Map;

/**
 * 값이 같지만 순서가 다른 2개의 배열 위치를 찾는 문제!
 */
public class FindAnagramsMapping {

    public static void main(String[] args) {
        int[] A = {11, 27, 45, 31, 50};
        int[] B = {50, 11, 31, 45, 27};

        int[] result = anagramMapping(A, B);

        // A배열을 기준으로, output: [1 4 3 2 0]
        print(result);
    }

    private static int[] anagramMapping(int[] A, int[] B) {
        int[] result = new int[A.length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            map.put(B[i], i); // 1,4,3,2,0
        }

        for (int i = 0; i < A.length; i++) {
            result[i] = map.get(A[i]);  // 1 4 3 2 0
        }

        return result;
    }

    private static void print(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
