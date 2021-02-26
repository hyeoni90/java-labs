package com.hyeonah.javalabs.algorithm.top50coding.stringAndArray;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hyeoni90 on 2021-02-15
 *
 * ex1)
 * input: "ccaabbb"
 * output: 5 (length of `aabbb`)
 *
 * ex2)
 * input: "eceba"
 * output: 3 (length of `ece`)
 *
 * keyword >
 * Map, Two Pointer, Math.max
 * (start, end 를 알아야하며, end-start 한 length 를 알아야 한다.)
 */
public class LongestSubstringWithAtMostTwoDistinct {

    public static void main(final String[] args) {
        final String str = "ccaabbb";
        final String str1 = "eceba";
        System.out.println(new LongestSubstringWithAtMostTwoDistinct().solution(str));
        System.out.println(new LongestSubstringWithAtMostTwoDistinct().solution(str1));
    }

    private int solution(final String str) {
        int start = 0;
        int count = 0;  // 문자열의 문자 갯수..2
        int maxLength = 0;

        // 문자열의 문자과 문자 갯수
        final Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            final char endChar = str.charAt(i);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1); // cß=2, a=2, b=3

            if (map.get(endChar) == 1) {
                count++;
            }

            // 기존에 담겨 있던 문자을 삭제한다.
            if (count > 2) {
                final char startChar = str.charAt(start); // c
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0) {
                    count--;
                }
                start++;
            }

            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }
}
