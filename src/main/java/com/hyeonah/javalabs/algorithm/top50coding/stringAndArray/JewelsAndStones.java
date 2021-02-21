package com.hyeonah.javalabs.algorithm.top50coding.stringAndArray;

import java.util.HashSet;
import java.util.Set;

/**
 * keyword: HashSet (중복 허용x)
 */
public class JewelsAndStones {

    public static void main(final String[] args) {
        final String J = "aA";
        final String S = "aAAbbbb";
        System.out.println(solution(J, S)); // 3
    }

    private static int solution(final String jewels, final String stones) {
        final Set<Character> set = new HashSet<>();
        for (final char jewel : jewels.toCharArray()) {
            set.add(jewel); // a, A
        }

        int count = 0;
        for (final char stone : stones.toCharArray()) {
            if (set.contains(stone)) {
                count++;
            }
        }
        return count;
    }
}
