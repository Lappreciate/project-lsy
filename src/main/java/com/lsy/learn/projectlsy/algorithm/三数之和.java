package com.lsy.learn.projectlsy.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 1, 1, 2, 2};
        System.out.println(new 三数之和().threeSum(nums));
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) return lists;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int cur = nums[i];
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int tmp = cur + nums[R] + nums[L];
                if (tmp == 0) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(cur);
                    tmpList.add(nums[L]);
                    tmpList.add(nums[R]);
                    lists.add(tmpList);
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                } else if (tmp < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return lists;
    }
}
