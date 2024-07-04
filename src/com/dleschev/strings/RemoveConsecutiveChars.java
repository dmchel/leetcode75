package com.dleschev.strings;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Interview task 06.2024
 */

public class RemoveConsecutiveChars {

    public static void main(String[] args) {
        System.out.println(remove("abcfddfer"));
        System.out.println(remove("z55z"));
        System.out.println(remove("zmmmmz"));
    }

    private static int remove(String str) {
        Deque<Character> charStack = new ArrayDeque<>();
        int i = 0;
        boolean isDrop = false;
        while (i < str.length()) {
            if (!charStack.isEmpty() && charStack.peek().equals(str.charAt(i))) {
                i++;
                isDrop = true;
            }
            else {
                if (isDrop) {
                    charStack.pop();
                    isDrop = false;
                } else {
                    charStack.push(str.charAt(i++));
                }
            }
        }
        if (isDrop) {
            charStack.pop();
        }
        return charStack.size();
    }

}
