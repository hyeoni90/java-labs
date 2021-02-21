package com.hyeonah.javalabs.algorithm.top50coding.stringAndArray;

import java.util.ArrayList;
import java.util.List;

/**
 * anagrams?
 * 같은 순서만 다르지만 패턴은 같다?의 의미.
 */
public class FindAllAnagrams {

    /**
     * String text = "BACDGABCDA"
     * String pattern = "ABCD" 라면,
     * <p>
     * output: 0, 5, 6
     * BACD 이 구간의 시작 - 0
     * ABCD 이 구간의 시작 - 5
     * BCDA 이 구간의 시작 - 6
     *
     * @param args
     */
    public static void main(final String[] args) {
        final String text = "BACDGABCDA";
        final String pattern = "ABCD";
        System.out.println(new FindAllAnagrams().solution(text, pattern));
        // pattern ABCD 아스키 코드 값 array에 담는다.
    }

    private List<Integer> solution(final String text, final String pattern) {
        // 1.
        final List<Integer> result = new ArrayList<>();
        if (text == null || text.length() == 0 || pattern == null || pattern.length() == 0 || text.length() < pattern.length()) {
            return result;
        }

        // 2
        final int[] patternArr = new int[256]; // 0,0,0,0,0,0,1,1,1,1,0,0,0
        for (int i = 0; i < pattern.length(); i++) {
            patternArr[pattern.charAt(i)]++;
        }

        for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
            final int[] textArr = new int[256];
            for (int j = 0; j < pattern.length(); j++) {
                textArr[text.charAt(i + j)]++; // i=0, 0123 / i=1, 1234
            }

            if (check(patternArr, textArr)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean check(final int[] patternArr, final int[] textArr) {
        for (int i = 0; i < patternArr.length; i++) {
            if (patternArr[i] != textArr[i]) {
                return false;
            }
        }
        return true;
    }
}
