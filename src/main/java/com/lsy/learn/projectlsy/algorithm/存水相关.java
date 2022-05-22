package com.lsy.learn.projectlsy.algorithm;

/**
 * 存水相关
 */
public class 存水相关 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new 存水相关().maxArea(arr));
    }

    public int maxArea(int[] height) {
        int len = height.length;
        if (len == 0 || len == 1) {
            return 0;
        }

        int start = 0;
        int end = len - 1;
        int max = -1;
        while (start < end) {
            int tmp = Math.min(height[start], height[end]) * (end - start);
            if (tmp > max) {
                max = tmp;
            }
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }



    public int trap(int[] height) {
        int len = height.length;
        if (len == 0 || len == 1) {
            return 0;
        }

        int max_left = height[0];
        int max_right = height[len - 1];
        int left = 0;
        int right = len - 1;
        int sum = 0;
        while (left < right) {
            if (max_left < max_right) {
                sum += max_left - height[left];
                left++;
                max_left = Math.max(max_left, height[left]);
            } else {
                sum += max_right - height[right];
                right--;
                max_right = Math.max(max_right, height[right]);
            }
        }

        return sum;
    }
}
