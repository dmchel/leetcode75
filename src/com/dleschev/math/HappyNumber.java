package com.dleschev.math;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        System.out.println("Input: 19\nOutput: " + isHappy(19));
        System.out.println("Input: 2\nOutput: " + isHappy(2));
    }

    public static boolean isHappy(int number) {
        final Set<Integer> prevNumbers = new HashSet<>();
        int nextNumber = 0;
        while (nextNumber != 1) {
            if (prevNumbers.contains(number)) {
                // endless loop started
                break;
            }
            nextNumber = calcSumOfSquares(number);
            prevNumbers.add(number);
            number = nextNumber;
        }
        return nextNumber == 1;
    }

    public static int calcSumOfSquares(int number) {
        int sum = 0;
        while (number != 0) {
            sum += (int) Math.pow(number % 10, 2);
            number /= 10;
        }
        return sum;
    }

}
