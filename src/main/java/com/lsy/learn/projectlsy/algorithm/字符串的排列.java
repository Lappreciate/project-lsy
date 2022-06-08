package com.lsy.learn.projectlsy.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 字符串的排列 {

    List<String> res = new ArrayList<>();

    public static void main(String[] args) {

        String s = "aab";
        System.out.println(Arrays.toString(new 字符串的排列().permutation(s)));
    }

    public String[] permutation(String s) {

        List<Character> list = new ArrayList<>();
        dfs(s, list);
        String[] s1 = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            s1[i] = res.get(i);
        }
        return s1;
    }


    private void dfs(String s, List<Character> list) {
        if (list.size() == s.length()) {
            String transfer = transfer(list);
//            if(!res.contains(transfer)){
                res.add(transfer(list));
//            }
            return;
        }

        for (int i = 0; i < s.length(); i++) {
//            if (list.contains(s.charAt(i))) {
//                continue;
//            }

            list.add(s.charAt(i));
            dfs(s, list);
            list.remove(list.size() - 1);
        }
    }

    private String transfer(List<Character> list) {
        StringBuilder s = new StringBuilder();
        for (char c : list) {
            s.append(c);
        }
        return s.toString();
    }
}
