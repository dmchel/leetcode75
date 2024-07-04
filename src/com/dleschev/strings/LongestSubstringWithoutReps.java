package com.dleschev.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutReps {

    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println("Input: " + input);
        System.out.println("Solution1: " + lengthOfLongestSubstring(input));
        System.out.println("Solution2: " + lengthOfLongestSubstringLeetcode(input));

        input = "bbbbb";
        System.out.println("Input: " + input);
        System.out.println("Solution1: " + lengthOfLongestSubstring(input));
        System.out.println("Solution2: " + lengthOfLongestSubstringLeetcode(input));

        input = "dvdf";
        System.out.println("Input: " + input);
        System.out.println("Solution1: " + lengthOfLongestSubstring(input));
        System.out.println("Solution2: " + lengthOfLongestSubstringLeetcode(input));

        input = "asjrgapa";
        System.out.println("Input: " + input);
        System.out.println("Solution1: " + lengthOfLongestSubstring(input));
        System.out.println("Solution2: " + lengthOfLongestSubstringLeetcode(input));

        input = " ";
        System.out.println("Input: " + input);
        System.out.println("Solution1: " + lengthOfLongestSubstring(input));
        System.out.println("Solution2: " + lengthOfLongestSubstringLeetcode(input));

        input = "abba";
        System.out.println("Input: " + input);
        System.out.println("Solution1: " + lengthOfLongestSubstring(input));
        System.out.println("Solution2: " + lengthOfLongestSubstringLeetcode(input));

    }

    // My solution
    public static int lengthOfLongestSubstring(String s) {
        List<Integer> substringLengths = new ArrayList<>();
        int start = 0;
        while (start != s.length()) {
            Map<Character, Integer> dict = new HashMap<>();
            for (int i = start; i < s.length(); i++) {
                if (dict.containsKey(s.charAt(i))) {
                    start = dict.get(s.charAt(i)) + 1;
                    break;
                }
                dict.put(s.charAt(i), i);
                start++;
            }
            substringLengths.add(dict.size());
        }

        int maxLen = 0;
        for (Integer len : substringLengths) {
            if (maxLen < len) {
                maxLen = len;
            }
        }
        return maxLen;
    }

    // Somewhat Leetcode solution with a HashSet
    public static int lengthOfLongestSubstringLeetcode(String s) {
        int maxLen = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            if (charSet.contains(s.charAt(right))) {
                do {
                    charSet.remove(s.charAt(left++));
                } while (charSet.contains(s.charAt(right)));
                charSet.add(s.charAt(right));
            } else {
                charSet.add(s.charAt(right));
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }

}
