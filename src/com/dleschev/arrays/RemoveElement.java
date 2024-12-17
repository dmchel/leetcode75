package com.dleschev.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = { 0,1,2,2,3,0,4,2 }; // Input array
        int val = 2; // Value to remove
        int[] expectedNums = { 0, 0, 1, 3, 4 }; // The expected answer with correct length.
        // It is sorted with no values equaling val.

        int k = removeElementLeetcode(nums, val); // Calls your implementation

        System.out.println("--------------------");
        System.out.println(Arrays.toString(nums));

        if (k != expectedNums.length) {
            throw new IllegalStateException("Return value is not correct: " + k);
        }
        Arrays.sort(nums, 0, k); // Sort the first k elements of nums
        for (int i = 0; i < expectedNums.length; i++) {
            if (nums[i] != expectedNums[i]) {
                throw new IllegalStateException("Resulting array element mismatch at index " + i);
            }
        }

        /*var list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        var result = list.stream().map(n -> n * 2).filter(n -> n > 10).collect(Collectors.toList());
        System.out.println(result);*/
    }

    // My over-comlicated solution
    private static int removeElement(int[] nums, int val) {
        int k = 0;
        while (k < nums.length) {
            if (nums[k] == val) {
                int i = k + 1;
                while (i < nums.length && nums[i] == val) {
                    i++;
                }
                if (i == nums.length) {
                    break;
                } else {
                    nums[k] ^= nums[i];
                    nums[i] ^= nums[k];
                    nums[k] ^= nums[i];
                }
            }
            k++;
        }
        k = 0;
        while (k < nums.length) {
            if (nums[k] == val) {
                break;
            }
            k++;
        }
        return k;
    }

    private static int removeElementLeetcode(int[] nums, int val) {
        int index = 0;
        for (int num : nums) {
            if (num != val) {
                nums[index++] = num;
            }
        }
        return index;
    }

}
