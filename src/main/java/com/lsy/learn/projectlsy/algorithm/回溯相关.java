package com.lsy.learn.projectlsy.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yanhuidsdsdsdsdsd
 * @date 2021/3/8 15:55
 */
public class 回溯相关 {

    public static void main(String[] args) {
        new 回溯相关().permute(new int[]{1, 2, 3});
    }

    private void permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new ArrayList<>(), res);

    }

    private void dfs(int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums, list, res);
            list.remove(list.size() - 1);
        }
    }
}

