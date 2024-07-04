package com.dleschev.arrays;

import java.util.Arrays;

/**
 * Interview task 06.2024
 */

public class SortedRotatedSearch {

    public static void main(String[] args) {
        int[] input = { 10, 11, 12, 15, 1, 4, 6, 7 };
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Test output: ");
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]  + " - " + findElement(input, input[i]));
        }
        System.out.println("Negative test:");
        System.out.println("334 - " + findElement(input, 334));
    }

    private static int findElement(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        // No rotation case, just perform a binary search on the array
        if (array[start] < array[end]) {
            return binarySearch(array, 0, array.length - 1, target);
        }
        int pivot = findPivotIndex(array);
        System.out.println("Pivot: " + pivot);
        if (target >= array[0]) {
            return binarySearch(array, 0, pivot - 1, target);
        } else {
            return binarySearch(array, pivot, array.length - 1, target);
        }

    }

    private static int binarySearch(int[] array, int start, int end, int target) {
        //int start = 0;
        //int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return mid;
            }
            // Ignore left part
            if (array[mid] < target) {
                start = mid + 1;
            // Ignore right part
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private static int findPivotIndex(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return i;
            }
        }
        return 0;

        /*int start = 0;
        int end = array.length - 1;
        int pivot = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            //System.out.println("Curr mid: " + mid);
            // Go left
            if (array[start] > array[mid]) {
                end = mid - 1;
            }
            // Go right
            else if(array[mid + 1] > array[end]) {
                start = mid + 1;
            } else {
                return mid;
            }
            pivot = mid;
        }

        return pivot;*/
    }

}
