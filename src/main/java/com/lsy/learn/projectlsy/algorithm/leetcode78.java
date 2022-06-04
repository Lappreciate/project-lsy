package com.lsy.learn.projectlsy.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集
 */
public class leetcode78 {

    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3};
        new leetcode78().subsets(num);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new ArrayList<>(), res, 0);
        res.add(new ArrayList<>());
        System.out.println(res);
        return res;
    }


//[[1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3], []]
    private void dfs(int[] nums, List<Integer> list, List<List<Integer>> res, int start) {
        if (list.size() == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {

            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            dfs(nums, list, res, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
