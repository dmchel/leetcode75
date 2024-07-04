package com.dleschev.strings;

import java.util.LinkedList;
import java.util.List;

public class MultiplyStrings {

    public static void main(String[] args) {
        System.out.println("Input: num1 = \"2\", num2 = \"3\"");
        System.out.println("Output: " + multiply("2", "3"));
        System.out.println("Input: num1 = \"123\", num2 = \"456\"");
        System.out.println("Output: " + multiply("123", "456"));
    }

    public static String multiply(String num1, String num2) {
        List<String> lines = new LinkedList<>();
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            final StringBuilder sb = new StringBuilder();
            for (int j = num1.length() - 1; j >= 0; j--) {
                int prod = num1.charAt(j) * num2.charAt(i) + carry;
                carry = prod / 10;
                sb.append(prod % 10);
            }
            lines.add(sb.toString());
        }
        // TODO find sum of lines
        return "";
    }

}
