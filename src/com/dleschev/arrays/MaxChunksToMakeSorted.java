package com.dleschev.arrays;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/max-chunks-to-make-sorted/description/">...</a>
 */
public class MaxChunksToMakeSorted {

    public static void main(String[] args) {
        int[] input1 = {4,3,2,1,0};
        int[] input2 = {1,0,2,3,4};
        int[] input3 = {1,4,3,6,0,7,8,2,5};

        System.out.println(Arrays.toString(input1) + " -> " + maxChunksToSorted(input1));
        System.out.println(Arrays.toString(input2) + " -> " + maxChunksToSorted(input2));
        System.out.println(Arrays.toString(input3) + " -> " + maxChunksToSorted(input3));
    }

    /**
     * Solution based on the fact that in given conditions, prefix sum of sorted array equals to the sum of indexes
     */
    public static int maxChunksToSorted(int[] arr) {
        int sum = 0;
        int indexSum = 0;
        int chunks = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            indexSum += i;
            if (sum == indexSum) {
                chunks++;
            }
        }
        return chunks;
    }

}
