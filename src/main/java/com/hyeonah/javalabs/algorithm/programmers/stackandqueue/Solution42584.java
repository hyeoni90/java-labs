package com.hyeonah.javalabs.algorithm.programmers.stackandqueue;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 스택/큐 > 주식가격
 */
public class Solution42584 {

    public static void main(final String[] args) {
        final int[] prices = {1, 2, 3, 2, 3};

        final String result = Arrays.stream(new Solution42584().solution(prices))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }

    public int[] solution(final int[] prices) {
        final int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int count = 0;
            for (int j = i + 1; j < prices.length; j++) {
                count++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}
