package com.dleschev.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] input = { -1, -5, 6, 10, 3, 99, 5, 2, 4, 0, -5, -1000, 98 };
        int[] inputCopy = Arrays.copyOf(input, input.length);
        Arrays.sort(inputCopy);
        System.out.println("Input: " + Arrays.toString(input));
        sort(input);
        System.out.println("Output: " + Arrays.toString(input));
        System.out.println("Expected output: " + Arrays.toString(inputCopy));
        for (int i = 0; i < input.length; i++) {
            if (input[i] != inputCopy[i]) {
                throw new IllegalStateException("Expectation failed for element num=" + i);
            }
        }
    }

    private static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

}
