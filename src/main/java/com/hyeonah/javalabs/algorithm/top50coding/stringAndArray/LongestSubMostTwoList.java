package com.hyeonah.javalabs.algorithm.top50coding.stringAndArray;

import java.util.HashMap;
import java.util.Map;

public class LongestSubMostTwoList {

    public static void main(final String[] args) {
        final String str = "ccaabbb";
        System.out.println(solution(str));
    }

    private static int solution(final String str) {
        int start = 0;
        int end = 0;
        int length = 0;
        int counter = 0;

        final Map<Character, Integer> map = new HashMap<>();

        while(end < str.length()) {
            final char endChar = str.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);

            if (map.get(endChar) == 1) {
                counter++;
            }

            end++;

            while (counter > 2) {
                final char startChar = str.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                if(map.get(startChar) == 0){
                    counter --;
                }
                start++;
            }
            length = Math.max(length, end - start);
        }
        return length;
    }
}
