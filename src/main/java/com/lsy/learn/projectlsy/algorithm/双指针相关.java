package com.lsy.learn.projectlsy.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 双指针相关 {

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };
        System.out.println(Arrays.deepToString(new 双指针相关().merge(a)));
    }

    public int[][] merge(int[][] intervals) {

        //需要先排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> list = new ArrayList<>(intervals.length);
        for (int i = 0; i < intervals.length; ) {

            int t = intervals[i][1];
            int j = i + 1;
            while (j < intervals.length && intervals[j][0] <= t) {
                t = Math.max(t, intervals[j][1]);
                j++;
            }
            list.add(new int[]{intervals[i][0], t});
            i = j;
        }

        int[][] res = new int[list.size()][2];

        int k = 0;
        for (int[] arr : list) {
            res[k][0] = arr[0];
            res[k][1] = arr[1];
            k++;
        }
        return res;

    }
}
