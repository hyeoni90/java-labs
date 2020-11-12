package com.hyeonah.studyjava.java8to11.array;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by hyeonahlee on 2020-11-12.
 *
 * Arrays.parallelSort()
 * - Fork/Join framework를 사용 해서 배열을 병렬로 정렬 하는 기능 제공
 *
 * 병렬 정렬 알고리즘
 *  - 배열을 둘로 계속 쪼갠다.
 *  - 합치면서 정렬한다.
 *
 *  sort() VS parallel()
 *  알고리즘 효율성은 같지만,
 */
public class Parallel {

    public static void main(String[] args) {

        int size = 1500;
        int[] numbers = new int[size];
        Random random = new Random();

        IntStream.range(0, size)
                .forEach(i -> numbers[i] = random.nextInt());
        long start = System.nanoTime();
        Arrays.sort(numbers); // >>>  Dual-Pivot QuickSort!, Single thread 라서 한계가 있음
        System.out.println("serial sorting took " + (System.nanoTime() - start));


        IntStream.range(0, size)
                .forEach(i -> numbers[i] = random.nextInt());
        start = System.nanoTime();
        Arrays.parallelSort(numbers); // >>> 분산 스레드 같은 알고리즘임에도 불구하고 속도가 조금 빠르다 (but, 리소스에 따라 달라짐)

        System.out.println("parallel sorting took " + (System.nanoTime() - start));
    }
}
