package com.dleschev.arrays;

import java.util.Arrays;

public class BestTimeStocks {

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};
        int[] prices3 = {1, 4, 2};

        System.out.println("Input: " + Arrays.toString(prices1));
        System.out.println("Output: " + maxProfit(prices1));

        System.out.println("Input: " + Arrays.toString(prices2));
        System.out.println("Output: " + maxProfit(prices2));

        System.out.println("Input: " + Arrays.toString(prices3));
        System.out.println("Output: " + maxProfit(prices3));
    }

    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }
}
