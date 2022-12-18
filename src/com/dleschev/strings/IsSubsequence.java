package com.dleschev.strings;

public class IsSubsequence {

    private static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        if (t.isEmpty()) {
            return false;
        }
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            index = t.indexOf(s.charAt(i), index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Input: s=\"abc\" t=\"ahbgdc\"");
        System.out.println("Output: " + isSubsequence("abc", "ahbgdc"));
        System.out.println("Input: s=\"axc\" t=\"ahbgdc\"");
        System.out.println("Output: " + isSubsequence("axc", "ahbgdc"));
    }
}
