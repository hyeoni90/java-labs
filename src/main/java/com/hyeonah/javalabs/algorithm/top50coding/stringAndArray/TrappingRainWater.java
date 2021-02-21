package com.hyeonah.javalabs.algorithm.top50coding.stringAndArray;

/**
 * Created by hyeoni90 on 2021-02-15
 *
 * keypoint! 기준으로 양옆 left, right 를 보고 작은 값을 따라간다.
 * 1. left, right 배열을 구한다. (left는 왼쪽부터 기준으로 right는 오른쪽 기준으로)
 * 2. left, right 기준으로 작은 값에 대한 배열을 구한다.
 * 3. left, right 기준 배열 값에서 height 를 비교한 만큼 물이 채워 지게 된다!
 *
 * int[] left =
 * int[] right =
 * Math.min
 * height
 */
public class TrappingRainWater {

    public static void main(final String[] args) {
        final int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new TrappingRainWater().solution(height));
    }

    private int solution(final int[] height) {
        int result = 0;
        if (height == null || height.length <= 2) {
            return result;
        }

        // 1. left ex) {0,1,1,2,2,2,2,3,3,3,3,3}
        final int[] left = new int[height.length];
        final int[] right = new int[height.length];

        int max = height[0];
        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            if (max < height[i]) {
                left[i] = height[i];
                max = height[i];
            } else {
                left[i] = max;
            }
        }

        // 2. right ex) {3,3,3,3,3,3,3,3,2,2,2,1}
        max = height[height.length - 1];
        right[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            if (max < height[i]) {
                right[i] = height[i];
                max = height[i];
            } else {
                right[i] = max;
            }
        }

        // 3. left, right min 값 배열
        for (int i = 0; i < height.length; i++) {
            result += Math.min(left[i], right[i]) - height[i];
        }

        return result;
    }
}
