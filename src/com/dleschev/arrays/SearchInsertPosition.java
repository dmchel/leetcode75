package com.dleschev.arrays;

import java.util.Arrays;

public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] input1 = {1,3,5,6};
        System.out.println(Arrays.toString(input1));
        System.out.println("target = 5, output = " + searchInsert(input1, 5));
        System.out.println("target = 2, output = " + searchInsert(input1, 2));
        System.out.println("target = 3, output = " + searchInsert(input1, 3));
        System.out.println("target = 1, output = " + searchInsert(input1, 1));
        System.out.println("target = 7, output = " + searchInsert(input1, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        if (target > nums[end - 1]) {
            return end;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2; // avoiding potential integer overflow
            //System.out.println("s/m/e: " + start + "/" + mid + "/" + end);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

}
