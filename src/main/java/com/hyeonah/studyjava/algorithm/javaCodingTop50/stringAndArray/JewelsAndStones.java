package com.hyeonah.studyjava.algorithm.javaCodingTop50.stringAndArray;

import java.util.HashSet;
import java.util.Set;

/**
 * keyword: HashSet (중복 허용x)
 */
public class JewelsAndStones {

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(solution(J, S)); // 3
    }

    private static int solution(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (char jewel : jewels.toCharArray()) {
            set.add(jewel); // a, A
        }

        int count = 0;
        for (char stone : stones.toCharArray()) {
            if (set.contains(stone)) {
                count++;
            }
        }
        return count;
    }
}
