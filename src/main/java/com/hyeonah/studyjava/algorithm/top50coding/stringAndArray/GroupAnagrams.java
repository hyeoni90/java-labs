package com.hyeonah.studyjava.algorithm.top50coding.stringAndArray;

import java.util.*;

/**
 * Created by hyeoni90 on 2021-02-15
 *
 * 동일한 문자열로 이루어진 순서만 다른 것!
 * input : ["eat", "ate", "tea", "tan", "nat", "bat"]
 * output: [["ate", "eat", "tea"], ["nat", "tan"], ["bat"]]
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] input = {"eat", "ate", "tea", "tan", "nat", "bat"};
        System.out.println(new GroupAnagrams().solution(input));
    }

    private List<List<String>> solution(String[] input) {
        List<List<String>> result = new ArrayList<>();

        if(input == null || input.length == 0) {
             return result;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : input) {
            char[] charArr = str.toCharArray();

            // 2. 문자 배열 정렬
            Arrays.sort(charArr);

            // 3. key 중복 체크
            String key = String.valueOf(charArr);
            if(map.containsKey(key)) {
                map.get(key).add(str);
                // key values 정렬
                Collections.sort(map.get(key));
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        result.addAll(map.values());
        return result;
    }
}
