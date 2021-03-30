package com.hyeonah.javalabs.algorithm.programmers.heap;

import java.util.PriorityQueue;

public class Solution42626 {

    public static void main(final String[] args) {
        final int[] scoville = {1, 2, 3, 9, 10, 12};
        System.out.println(new Solution42626().solution(scoville, 7));
    }

    public int solution(final int[] scoville, final int K) {
        final PriorityQueue<Integer> queue = new PriorityQueue<>();
        int answer = 0;

        for (final int i : scoville) {
            queue.offer(i);
        }

        while (queue.peek() < K){
            if(queue.size() == 1) {
                return -1;
            }

            final int result = queue.poll() + (queue.poll() * 2);   // first + (second * 2)

            queue.offer(result);
            answer++;
        }
        return answer;
    }
}
