package com.lsy.learn.projectlsy.test.forkJoinTest;

import java.util.concurrent.ForkJoinPool;

public class Test {
    public static void main(String[] args) {
//        ForkJoinPool pool = new ForkJoinPool();
//
//        long start = System.currentTimeMillis();
//
//        long sum = pool.invoke(new ForkJoinCalculate(0, 10000000000L));
//
//        long end = System.currentTimeMillis();
//
//        System.out.println(end - start);
//        System.out.println(sum);

        long sum = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000000L; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(sum);
    }
}
