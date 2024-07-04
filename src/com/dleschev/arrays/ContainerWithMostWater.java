package com.dleschev.arrays;

import java.util.Arrays;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] input = { 1,8,6,2,5,4,8,3,7 };
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Output: " + maxArea(input));

        int[] input1 = { 1, 1 };
        System.out.println("Input: " + Arrays.toString(input1));
        System.out.println("Output: " + maxArea(input1));

        int[] input2 = { 2,3,4,5,18,17,6 };
        System.out.println("Input: " + Arrays.toString(input2));
        System.out.println("Output: " + maxArea(input2));

    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;

        while (left != right) {
            int currArea = (right - left) * Math.min(height[left], height[right]);
            area = Math.max(area, currArea);
            // Always move the pointer that points to the lower height
            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return area;
    }

}
