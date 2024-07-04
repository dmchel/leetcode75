package com.dleschev.pooh;

import java.util.Locale;
import java.util.Scanner;

public class Fractions {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        int n = in.nextInt();
        double x = in.nextDouble();
        double minNum = 1.0;
        int denominator = 1;
        int numerator = 1;

        for (int j = 1; j < n; j++) {
            for (int i = 2; i <= n; i++) {
                if (Math.abs(x - minNum) > Math.abs(x - ((double) j / i)) /*&& ((double) numerator / denominator != (double) i / j)*/) {
                    minNum = (double) j / i;
                    denominator = i;
                    numerator = j;
                }
            }
        }
        System.out.println(numerator + " " + denominator);
    }

}
