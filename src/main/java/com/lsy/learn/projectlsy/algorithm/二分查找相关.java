package com.lsy.learn.projectlsy.algorithm;

public class 二分查找相关 {

    public static void main(String[] args) {
//        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] nums = new int[]{3, 1};
        System.out.println(new 二分查找相关().search(nums, 1));
    }

    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {//注意必须是等于 {3,1}
                //左边有序 需要定位目标确实是在范围内  单一条件判断会导致漏掉
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //右边有序
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }

        return -1;

    }

}
