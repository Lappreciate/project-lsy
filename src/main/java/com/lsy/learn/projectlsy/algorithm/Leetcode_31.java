package com.lsy.learn.projectlsy.algorithm;

import java.util.Arrays;

/**
 * 1 5 4 3 3 1
 * 找到相邻的第一个升序 [1 5] 取1
 * 从后往前找到第一个比 1大的元素( index=n-2 :3)  二者交换
 * 变成 [3] 5 4 3 [1] 1
 * [3] 5 4 3 [1] 1 将3后面元素 排列或者reverse 将损失降到最低
 */
public class Leetcode_31 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,1,1};
        new Leetcode_31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {

        if (nums == null || nums.length == 1) {
            return;
        }

        int index = nums.length - 2;

        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }

        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        if (index == nums.length - 2) {
            swap(nums, index, index + 1);
            return;
        }

        int j = nums.length - 1;
        while (j >= 0) {
            if (nums[j] > nums[index]) {
                break;
            }
            j--;
        }

        swap(nums, index, j);
        reverse(nums, index + 1, nums.length - 1);

    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

}
