package com.hyeonah.javalabs.algorithm.programmers.hash;

import java.util.Map;
import java.util.TreeMap;

/**
 * 해시 > 전화번호 목록
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 */
public class Solution42577 {

    public static void main(final String[] args) {
        final String[] phone_book = {"119", "97674223", "1195524421"};
//    String[] phone_book = {"123","456","789"};
//    String[] phone_book = {"12","123","1235","567","88"};

        System.out.println(solution(phone_book));
    }

    public static boolean solution(final String[] phone_book) {
        boolean answer = true;
        final Map<String, Integer> phoneBookMap = new TreeMap<>();

        for (final String phoneNum : phone_book) {
            phoneBookMap.put(phoneNum, 0);
        }

        final String currentKey = ((TreeMap<String, Integer>) phoneBookMap).firstKey();

        for (final String key : phoneBookMap.keySet()) {
            if (currentKey.equals(key)) {
                continue;
            } else {
                if (key.startsWith(currentKey)) {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}
