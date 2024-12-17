package com.dleschev.strings;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println("babad -> " + longestPalindrome("babad"));
        System.out.println("cbbd -> " + longestPalindrome("cbbd"));
        System.out.println("ac -> " + longestPalindrome("ac"));
        System.out.println("abb -> " + longestPalindrome("abb"));
        System.out.println("aacabdkacaa -> " + longestPalindrome("aacabdkacaa"));
        longestPalindrome("cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
    }

    private static class Interval {
        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }
        public static Interval of(int left, int right) {
            return new Interval(left, right);
        }
        public int left;
        public int right;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Interval interval = (Interval) o;
            return left == interval.left && right == interval.right;
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right);
        }

    }

    public static String longestPalindrome(String s) {
        final Set<Interval> intervals = new HashSet<>();
        String result = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isPalindromeSubstring(s, intervals, i, j)) {
                    //intervals.add(Interval.of(i, j));
                    //System.out.println("add " + i + " " + j);
                    if (j - i + 1 > result.length()) {
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }
        return result;
    }

    private static boolean isPalindromeSubstring(String s, Set<Interval> intervals, int left, int right) {
        //System.out.println("l: " + left + " r: " + right);
        /*if (left > right) {
            return s.charAt(left) == s.charAt(right);
        } else if (left < right) {
            if (intervals.contains(Interval.of(left, right))) {
                return true;
            } else {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
                return isPalindromeSubstring(s, intervals, left, right);
            }
        }*/

        if (left > right) {
            return s.charAt(left) == s.charAt(right);
        }

        while (left < right) {
            /*if (intervals.contains(Interval.of(left, right))) {
                return true;
            } else*/ if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
