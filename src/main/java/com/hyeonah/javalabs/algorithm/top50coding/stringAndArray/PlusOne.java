package com.hyeonah.javalabs.algorithm.top50coding.stringAndArray;

import java.util.Arrays;

public class PlusOne {

    public static void main(final String[] args) {
        final int[] result = new PlusOne().solution(new int[]{1,2,3}); // [1,2,4]
        final int[] result_1 = new PlusOne().solution(new int[]{1,0,0,2}); // [1,0,0,3]
        final int[] result_2 = new PlusOne().solution(new int[]{9,9,9}); // [1,0,0,0]
        final int[] result_3 = new PlusOne().solution(new int[]{0,0,1}); // [0,0,2]

        Arrays.stream(result).forEach(System.out::print);
        System.out.println();
        Arrays.stream(result_1).forEach(System.out::print);
        System.out.println();
        Arrays.stream(result_2).forEach(System.out::print);
        System.out.println();
        Arrays.stream(result_3).forEach(System.out::print);
    }

    private int[] solution(final int[] digits) {
        // 뒷자리부터 9가 있는지 체크
        // 9가 아닌 경우는 해당 자리수의 값을 +1
        // 9인 경우에는 배열 index값이 한 개 증가한 상태가 된다.
        // 새로운 배열

        // 1. data structure array, list, map
        // 2. for, while 뒷 자리부터 for!
        for (int i = digits.length-1; i >= 0; i--) {
            if(digits[i] != 9) {
                digits[i]++;
                break;
            }

            // 9가 들어 왔을 때! 999인 케이스.. 새로운 배열을 만든다!
            if(i == 0) {
                final int[] result = new int[digits.length+1];
                result[0] = 1;
                return result;
            }
        }

        return digits;
    }
}
