package com.hyeonah.studyjava.algorithm.javaCodingTop50.stringAndArray;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 배열 에서 0이 아닌 요소 들은 상대 적인 순서 유지 하면서 0인 값들은 끝으로 이동
 */
public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = {0, 3, 2, 0, 8, 5};
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }

        System.out.print(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }
}
