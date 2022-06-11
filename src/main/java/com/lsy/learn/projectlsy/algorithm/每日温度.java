package com.lsy.learn.projectlsy.algorithm;

import java.util.Stack;

public class 每日温度 {

    public static void main(String[] args) {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        new 每日温度().dailyTemperatures(temperatures);
    }


    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] > temperatures[stack.peek()]) {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    Integer pop = stack.pop();
                    res[pop] = i - pop;
                }
            }
            stack.push(i);
        }


        return res;
    }
}
