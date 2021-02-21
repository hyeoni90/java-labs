package com.hyeonah.javalabs.algorithm.programmers.hash;

import java.util.HashMap;

/**
 * 해시 > 완주하지 못한 선수
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 */
public class Solution42576 {

    public static void main(final String[] args) {
        final String[] participant = {"leo", "leo", "kiki", "eden"};
        final String[] completion = {"kiki", "eden", "leo", "leo"};

        System.out.println(solution(participant, completion));
    }

    public static String solution(final String[] participant, final String[] completion) {
        String answer = "";
        final HashMap<String, Integer> marathonMap = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            if (marathonMap.containsKey(participant[i])) {
                marathonMap.put(participant[i], marathonMap.get(participant[i]) + 1);
            } else {
                marathonMap.put(participant[i], 1);
            }
        }

        for (final String compl : completion) {
            marathonMap.put(compl, marathonMap.get(compl) - 1);
        }

        for (final String key : marathonMap.keySet()) {
            if (marathonMap.get(key) > 0) {
                answer = key;
            }
        }

        return answer;
    }
}
