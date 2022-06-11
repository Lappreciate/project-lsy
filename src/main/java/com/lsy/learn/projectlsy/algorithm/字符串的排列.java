package com.lsy.learn.projectlsy.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 字符串的排列 {

    List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        String s = "suvyls";
        System.out.println(Arrays.toString(new 字符串的排列().permutation(s)));
    }

    public String[] permutation(String s) {
        boolean[] visit = new boolean[s.length()];

        List<Character> list = new ArrayList<>();
        dfs(transfer(s), list, visit);
        System.out.println(res.size());
        return res.toArray(new String[0]);
    }


    private char[] transfer(String s) {
        char[] tmp = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            tmp[i] = s.charAt(i);
        }
        Arrays.sort(tmp);
        return tmp;
    }


    private void dfs(char[] s, List<Character> list, boolean[] visit) {
        if (list.size() == s.length) {
            res.add(transfer(list));
            return;
        }

        for (int i = 0; i < s.length; i++) {

            if (visit[i]) {
                continue;
            }

            if (i < s.length - 1 && s[i] == s[i + 1] && visit[i + 1]) {
                continue;
            }

            visit[i] = true;
            list.add(s[i]);
            dfs(s, list, visit);
            list.remove(list.size() - 1);
            visit[i] = false;

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
