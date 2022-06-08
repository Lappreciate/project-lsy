package com.lsy.learn.projectlsy.algorithm;

import com.lsy.learn.projectlsy.controller.MyController1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//            if (i > 0 && nums[i] == nums[i - 1] && visit[i - 1]) {
//                continue;
//            }

/**
 * @author Yanhuidsdsdsdsdsd
 * @date 2021/3/8 15:55
 */
public class 回溯相关 {


    public static void main(String[] args) {
        new 回溯相关().permuteUnique(new int[]{3, 3, 3, 0});
    }

    private void permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);//防止 3, 3, 0, 3 时候 3和3之间出现0 导致重复
        boolean[] visit = new boolean[nums.length];
        dfs(nums, new ArrayList<>(), res, visit);
        System.out.println(Arrays.toString(res.toArray()));

    }

    private void dfs(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] visit) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            if (visit[i]) continue;


            if (i < nums.length - 1 && nums[i] == nums[i + 1] && visit[i + 1]) {
                continue;
            }

            visit[i] = true;
            list.add(nums[i]);
            dfs(nums, list, res, visit);
            list.remove(list.size() - 1);
            visit[i] = false;
        }
    }
}

