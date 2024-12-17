package com.dleschev.sort;

import java.util.Arrays;

public class MergeSort {

    public static void m    ain(String[] args) {
        int[] input = { -1, -5, 6, 10, 3, 99, 5, 2, 4, 0, -5, -1000, 98 };
        int[] inputCopy = Arrays.copyOf(input, input.length);
        Arrays.sort(inputCopy);
        System.out.println("Input: " + Arrays.toString(input));
        mergeSort(input);
        System.out.println("Output: " + Arrays.toString(input));
        System.out.println("Expected output: " + Arrays.toString(inputCopy));
        for (int i = 0; i < input.length; i++) {
            if (input[i] != inputCopy[i]) {
                throw new IllegalStateException("Expectation failed for element num=" + i);
            }
        }
    }

    private static void mergeSort(int[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;

            // Split the array into two halves
            int[] leftHalf = new int[mid];
            int[] rightHalf = new int[array.length - mid];

            System.arraycopy(array, 0, leftHalf, 0, mid);
            System.arraycopy(array, mid, rightHalf, 0, array.length - mid);

            // Recursively sort both halves
            mergeSort(leftHalf);
            mergeSort(rightHalf);

            // Merge the sorted halves
            merge(array, leftHalf, rightHalf);
        }
    }

    // Function to merge two sorted halves into a single sorted array
    private static void merge(int[] array, int[] leftHalf, int[] rightHalf) {
        int i = 0;
        int j = 0;
        int k = 0;

        // Merge the left and right halves into the original array
        while (i < leftHalf.length && j < rightHalf.length) {
            if (leftHalf[i] <= rightHalf[j]) {
                array[k++] = leftHalf[i++];
            } else {
                array[k++] = rightHalf[j++];
            }
        }

        // Copy any remaining elements of leftHalf
        while (i < leftHalf.length) {
            array[k++] = leftHalf[i++];
        }

        // Copy any remaining elements of rightHalf
        while (j < rightHalf.length) {
            array[k++] = rightHalf[j++];
        }
    }

}
