package com.hyeonah.studyjava.algorithm.top50coding.stringAndArray;

import java.util.HashMap;
import java.util.Map;

public class LongestSubMostTwoList {

    public static void main(String[] args) {
        String str = "ccaabbb";
        System.out.println(solution(str));
    }

    private static int solution(String str) {
        int start = 0;
        int end = 0;
        int length = 0;
        int counter = 0;

        Map<Character, Integer> map = new HashMap<>();

        while(end < str.length()) {
            char endChar = str.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);

            if (map.get(endChar) == 1) {
                counter++;
            }

            end++;

            while (counter > 2) {
                char startChar = str.charAt(start);
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
