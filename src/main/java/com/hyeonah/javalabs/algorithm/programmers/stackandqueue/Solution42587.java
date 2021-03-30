package com.hyeonah.javalabs.algorithm.programmers.stackandqueue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 스택/큐 > 프린터
 *
 * keyword) PriorityQueue
 *  - 내부 요소 heap 으로 이진트리 구조로 구성
 *  - 시간 복잡도: O(NlogN)
 */
public class Solution42587 {

    public static void main(final String[] args) {
        System.out.println(new Solution42587().solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(new Solution42587().solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    public int solution(final int[] priorities, final int location) {
        final PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 1;

        for (final int i : priorities) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if(queue.peek() == priorities[i]) {
                    if(location == i) {
                        return answer;
                    }
                    answer++;
                    queue.poll();
                }
            }
        }

        return answer;
    }
}
