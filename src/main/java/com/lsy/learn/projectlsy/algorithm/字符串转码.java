package com.lsy.learn.projectlsy.algorithm;

import java.util.Stack;

public class 字符串转码 {

    public static void main(String[] args) {
//        String s = "3[a2[c]]";
        String s = "2[abc]3[cd]ef";
        System.out.println(new 字符串转码().decodeString(s));
    }


    public String decodeString(String s) {

        StringBuilder sb = new StringBuilder();
        int len = s.length();

        Stack<Integer> num_stack = new Stack<>();
        Stack<String> s_stack = new Stack<>();

        int i = 0;
        while (i < len) {

            if (isNum(s, i)) {
                int num = 0;
                while (s.charAt(i) != '[') {
                    num += s.charAt(i) - '0';
                    i++;
                }
                num_stack.push(num);
            }
            i++;
            int start = i;
            if (isAlphabet(s, i)) {
                while (isAlphabet(s, i)) {
                    i++;
                }
            }
            s_stack.push(s.substring(start, i));

            if (s.charAt(i) == ']') {
                String res = "";
                while (i < len && s.charAt(i) == ']') {
                    StringBuilder sb1 = new StringBuilder();
                    Integer pop_num = num_stack.pop();
                    String pop_s = s_stack.pop();
                    res = pop_s + res;
                    for (int k = 0; k < pop_num; k++) {
                        sb1.append(res);
                    }
                    res = sb1.toString();
                    i++;
                }
                sb.append(res);
            }
        }
        return sb.toString();
    }

    private boolean isNum(String s, int i) {
        if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
            return true;
        }
        return false;
    }

    private boolean isAlphabet(String s, int i) {
        if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
            return true;
        }
        return false;
    }
}