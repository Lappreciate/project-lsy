package com.lsy.learn.projectlsy.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yanhuidsdsdsdsdsd
 * @date 2021/3/8 15:55
 */
public class 回溯相关 {

    boolean[] visit = new boolean[3];

    public static void main(String[] args) {
        new 回溯相关().permute(new int[]{1, 2, 3});
    }

    private void permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new ArrayList<>(), res);
        System.out.println(Arrays.toString(res.toArray()));

    }

    private void dfs(int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            list.add(nums[i]);
            dfs(nums, list, res);
            list.remove(list.size() - 1);
            visit[i] = false;
        }
    }
}

