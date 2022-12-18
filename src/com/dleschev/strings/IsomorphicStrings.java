package com.dleschev.strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    private static final String INPUT_FORMAT = "Input: s=\"%s\" t=\"%s\"\r\n";

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        for (int num = 0; num < s.length(); num++) {
            if (sMap.containsKey(s.charAt(num))) {
                if (sMap.get(s.charAt(num)) != t.charAt(num)) {
                    return false;
                }
            } else {
                sMap.put(s.charAt(num), t.charAt(num));
            }
        }
        Map<Character, Character> tMap = new HashMap<>();
        for (int num = 0; num < t.length(); num++) {
            if (tMap.containsKey(t.charAt(num))) {
                if (tMap.get(t.charAt(num)) != s.charAt(num)) {
                    return false;
                }
            } else {
                tMap.put(t.charAt(num), s.charAt(num));
            }
        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.printf(INPUT_FORMAT, "egg", "add");
        System.out.println("Output: " + isIsomorphic("egg", "add"));
        System.out.printf(INPUT_FORMAT, "foo", "bar");
        System.out.println("Output: " + isIsomorphic("foo", "bar"));
        System.out.printf(INPUT_FORMAT, "paper", "title");
        System.out.println("Output: " + isIsomorphic("paper", "title"));
        System.out.printf(INPUT_FORMAT, "badc", "baba");
        System.out.println("Output: " + isIsomorphic("bace", "baba"));

    }
}
