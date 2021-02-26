package com.hyeonah.javalabs.algorithm.top50coding.stringAndArray;

import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by hyeoni90 on 2021-02-26
 *
 * 입력받은 배열 중 가장 큰 요소 k 개(ex. 5,6), 첫번째 요소 추출
 *
 * keyword >
 * array 보다 훨씬 빠른 `PriorityQueue` 를 사용하는 것이 좋겠다.
 */
public class KthLargestElementInArray {

    public static void main(final String[] args) {
        final StopWatch stopWatch = new StopWatch("KthLargestElementInArray");

        final int[] nums = {3,2,1,5,6,4};
        final int k = 2;

        stopWatch.start("solutionWithArray");
        System.out.println(new KthLargestElementInArray().solutionWithArray(nums, k)); // 5
        stopWatch.stop();

        stopWatch.start("solutionWithPriorityQueue");
        System.out.println(new KthLargestElementInArray().solutionWithPriorityQueue(nums, k));  // 5
        stopWatch.stop();

//        System.out.println(stopWatch.shortSummary());
//        System.out.println(stopWatch.getTotalTimeMillis());
        System.out.println(stopWatch.prettyPrint());
    }

    //  1번째, array 이용
    private int solutionWithArray(final int[] nums, final int k) {
        final int length = nums.length; // 6
        Arrays.sort(nums);
        return nums[length-k];
    }

    // 2번째, ** PriorityQueue 이용 **
    private int solutionWithPriorityQueue(final int[] nums, final int k) {
        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comp);

        for (final int value : nums) {
            priorityQueue.offer(value);

            // head retrieve and remove
            if(priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }

    // java 8 lambda
    Comparator<Integer> Comp = Comparator.comparingInt(o -> o);

    // before java 8
    // Comparator<Integer> Comp = new Comparator<Integer>() {
    //     @Override
    //     public int compare(final Integer o1, final Integer o2) {
    //         return o1 - o2;
    //     }
    // };
}
