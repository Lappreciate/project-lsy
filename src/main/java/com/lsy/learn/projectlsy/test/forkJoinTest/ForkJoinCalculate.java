package com.lsy.learn.projectlsy.test.forkJoinTest;

import java.util.concurrent.RecursiveTask;

public class ForkJoinCalculate extends RecursiveTask<Long> {

    private long start;
    private long end;
    private static final long THRESHOLD = 10000L;

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long mid = (start + end) / 2;
            ForkJoinCalculate left = new ForkJoinCalculate(start, mid);
            left.fork();
            ForkJoinCalculate right = new ForkJoinCalculate(mid + 1, end);
            right.fork();
            return left.join() + right.join();
        }

    }
}
