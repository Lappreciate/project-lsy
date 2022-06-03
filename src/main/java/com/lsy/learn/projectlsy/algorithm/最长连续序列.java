package com.lsy.learn.projectlsy.algorithm;

import java.util.Arrays;

public class 最长连续序列 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0};
        System.out.println(new 最长连续序列().longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        Arrays.sort(nums);

        int len = nums.length;
        int res = 0;
        int calc = 1;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {
                calc++;
            } else {
                calc = 1;
            }
            if (nums[i] == nums[i + 1]) continue;
            res = Math.max(res, calc);
        }
        res = Math.max(res, calc);

        return res;
    }
}
