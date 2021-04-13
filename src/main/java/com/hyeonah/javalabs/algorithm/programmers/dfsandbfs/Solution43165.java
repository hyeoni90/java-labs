package com.hyeonah.javalabs.algorithm.programmers.dfsandbfs;

/**
 * DFS,BFS > 타겟넘버
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 *
 * 주어진 numbers에 +,- 연산 하는 경우 모두 탐색
 *
 */
public class Solution43165 {
    public static void main(final String[] args) {
        final int[] numbers = {1, 1, 1, 1, 1};
        final int target = 3;
        System.out.println(new Solution43165().solution(numbers, target)); // 5
    }

    // DFS, 재귀 이용
    public int solution(final int[] numbers, final int target) {
        return dfs(numbers, 0, 0, target);
    }

    private int dfs(final int[] numbers, final int index, final int sum, final int target) {
        if(index == numbers.length) {
            return sum == target ? 1 : 0;
        }
        return dfs(numbers, index + 1, sum + numbers[index], target)
                + dfs(numbers, index + 1, sum - numbers[index], target);
    }
}
