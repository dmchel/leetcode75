package com.dleschev.strings;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println("Input: [\"flower\", \"flight\", \"flow\"]");
        System.out.println("Output: " + longestCommonPrefix(new String[]{"flower", "flight", "flow"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        int index = -1;
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != c) {
                    return index == -1 ? "" : strs[0].substring(0, index + 1);
                }
            }
            index = i;
        }
        return strs[0];
    }

}
