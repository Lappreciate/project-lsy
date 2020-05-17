package com.lsy.learn.projectlsy.test;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8 行为参数化
 * <p>
 * Supplier<T>
 * <p>
 * Consumer<T>
 * <p>
 * Function<T,R>
 * <p>
 * Predicate<T>
 */
public class TestCommon {

    @Test
    void test() {
        Comparator<Integer> comparator = Integer::compare;
        System.out.println(comparator.compare(1, 2));
    }


    @Test
    void test1() {

    }
}
