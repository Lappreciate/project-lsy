package com.lsy.learn.projectlsy.algorithm;

public class 最接近的三数之和 {

    public static void main(String[] args) {
        int[] num = new int[]{-1, 2, 1, -4};
        System.out.println(new 最接近的三数之和().threeSumClosest(num, 1));
    }


    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;

        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {

            int restSum = target - nums[i];
            int L = i + 1;
            int R = len - 1;
            while (L < R) {

            }
        }

        return 0;

    }
}
