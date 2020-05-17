package com.lsy.learn.projectlsy.test;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

public class forkJoinTest {


    @Test
    void fork1() {
        ForkJoinPool pool = new ForkJoinPool();

        long start = System.currentTimeMillis();

        long sum = pool.invoke(new ForkJoinCalculate(0, 50000000000L));

        long end = System.currentTimeMillis();

        System.out.println(end - start);//9411
        System.out.println(sum);
    }

    @Test
    void fork2() {
        long sum = 0;
        long start = System.currentTimeMillis();
        for (long i = 0; i < 50000000000L; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);//12123
        System.out.println(sum);
    }

    /**
     * java8 顺序流
     */
    @Test
    void fork3() {
        long start = System.currentTimeMillis();
        Long sum = LongStream.rangeClosed(0, 10000000000L).reduce(0, Long::sum);
        long end = System.currentTimeMillis();

        System.out.println(sum);
        System.out.println(end - start);//3726
    }


    /**
     * java8 并行流
     */
    @Test
    void fork4() {
        long start = System.currentTimeMillis();
        Long sum = LongStream.rangeClosed(0, 10000000000L).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();

        System.out.println(sum);
        System.out.println(end - start);//1222
    }
}
