package com.lsy.learn.projectlsy.algorithm.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return 1;
        }

        Set<Character> set = new HashSet<>();
        int lengthOfLongestSubstring = -1;
        int start = 0;
        int end;
        for (end = 0; end < len; end++) {

            char e = s.charAt(end);
            while (set.contains(e)) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(e);
            lengthOfLongestSubstring = Math.max(end - start + 1, lengthOfLongestSubstring);
        }
        return lengthOfLongestSubstring;
    }
}
