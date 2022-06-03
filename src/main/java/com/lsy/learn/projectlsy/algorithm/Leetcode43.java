package com.lsy.learn.projectlsy.algorithm;

public class Leetcode43 {
    public static void main(String[] args) {
        System.out.println(new Leetcode43().multiply("123", "456"));
    }


    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] ans = new int[len1 + len2];
        int k = ans.length - 1;
        for (int i = len2 - 1; i >= 0; i--) {
            int n = k;
            for (int j = len1 - 1; j >= 0; j--) {
                int a = (num2.charAt(i) - '0');
                int b = (num1.charAt(j) - '0');
                ans[n--] += a * b;
            }
            k--;
        }
        System.out.println();
        int pos;
        for (pos = ans.length - 1; pos > 0; pos--) {
            int res = ans[pos] % 10;
            int carry = ans[pos] / 10;
            ans[pos] = res;
            ans[pos - 1] += carry;
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] != 0) {
                flag = true;
            }
            if(flag){
                sb.append(ans[i]);
            }
        }

        return sb.toString();
    }
}
