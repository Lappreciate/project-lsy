package com.lsy.learn.projectlsy.algorithm;

import java.util.Arrays;
import java.util.LinkedList;

public class 滑动窗口 {
    public static void main(String[] args) {
        int[] num = new int[]{9, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = new 滑动窗口().maxSlidingWindow(num, 3);
        System.out.println(Arrays.toString(ints));

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];

        LinkedList<Integer> queue = new LinkedList<>();

        for (int right = 0; right < nums.length; right++) {

            while (!queue.isEmpty() && right - queue.peekFirst() >= k) {
                queue.pollFirst();
            }

            while (!queue.isEmpty() && nums[right] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.add(right);

            if (right >= k - 1) {
                res[right - k + 1] = nums[queue.peekFirst()];
            }
        }

        return res;
    }

}
