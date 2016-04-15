package com.sbk.com.sbk.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StringSolution {

    public String multiply(String num1, String num2) {
        java.math.BigDecimal n1 = new java.math.BigDecimal(num1);
        java.math.BigDecimal n2 = new java.math.BigDecimal(num2);
        return  n1.multiply(n2).toString();
    }

    public static String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        int[] dict = new int[26];
        // initialize
        for(int i = 0; i < s.length(); i ++){
            dict[s.charAt(i)-'a'] += 1;
        }
        Stack<Character> stack = new Stack<Character>();
        int i = 0;

        // maintain the sequence, if the next character is better, push it into stack
        while(i < s.length()){
            char current = s.charAt(i);
            int index = current - 'a';
            // only take care of new characters that are not in the stack
            if(!stack.contains(current)) {
                while (!stack.isEmpty() &&  current <= stack.peek() && dict[stack.peek()-'a'] >= 1){
                    stack.pop();
                }
                if(!stack.contains(current)) {
                    stack.push(current);
                }
            }
            dict[index]--;
            i++;
        }

        // convert stack to result
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}
