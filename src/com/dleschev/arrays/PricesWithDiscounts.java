package com.dleschev.arrays;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class PricesWithDiscounts {

    public static void main(String[] args) {
        int[] prices1 = {8,4,6,2,3};
        System.out.println(Arrays.toString(finalPrices(prices1)));
    }

    public static int[] finalPrices(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = prices.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && prices[i] < stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                answer[i] = prices[i];
            } else {
                answer[i] = prices[i] - stack.peek();
            }
            stack.push(prices[i]);
        }
        return answer;
    }

}
