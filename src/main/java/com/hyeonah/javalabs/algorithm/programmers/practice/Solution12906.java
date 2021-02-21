package com.hyeonah.javalabs.algorithm.programmers.practice;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 같은 숫자는 싫어
 * https://programmers.co.kr/learn/courses/30/lessons/12906
 */
public class Solution12906 {
    
    public static void main(final String[] args) {
        final int[] arr = {1, 1, 3, 3, 0, 1, 1};
        System.out.println(Arrays.toString(new Solution12906().solution(arr)));
    }

    public int[] solution(final int[] arr) {
        return IntStream.range(0, arr.length)
                .filter(num -> {
                    if (num == 0) {
                        return true;
                    }
                    return arr[num - 1] != arr[num];
                })
                .map(num -> arr[num])
                .toArray();
    }

//    public int[] solution(int []arr) {
//        int beforeNum = -1;
//        List<Integer> numbers = new ArrayList<>();
//
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] != beforeNum)
//                numbers.add(arr[i]);
//            beforeNum = arr[i];
//        }
//
//        int[] answer = new int[numbers.size()];
//        for (int i = 0; i < numbers.size(); i++) {
//            answer[i] = numbers.get(i);
//        }
//
//        for(int i =0; i< answer.length; i++) {
//            System.out.println(answer[i]);
//        }
//        return answer;
//    }
}
