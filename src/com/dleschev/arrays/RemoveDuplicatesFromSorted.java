package com.dleschev.arrays;

import java.util.Arrays;

public class RemoveDuplicatesFromSorted {

    public static void main(String[] args) {
        int[] nums = { 0,0,1,1,1,2,2,3,3,4 };
        int[] expectedNums = { 0, 1, 2, 3, 4 };

        int k = removeDuplicates(nums);
        if (k != expectedNums.length) {
            throw new IllegalStateException("Return value is not correct " + k + " != " + expectedNums.length);
        }
        for (int i = 0; i < k; i++) {
            if(nums[i] != expectedNums[i]) {
                throw new IllegalStateException("Modified array doesn't match expectations at index " + i);
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(expectedNums));
    }

    public static int removeDuplicates(int[] input) {
        int currIndex = 1;
        int lastUpdatedIndex = 0;
        int curr = input[0];

        while (currIndex != input.length) {
            if (input[currIndex] != curr) {
                curr = input[currIndex];
                input[++lastUpdatedIndex] = curr;
            }
            currIndex++;
        }

        return lastUpdatedIndex + 1;
    }

}
