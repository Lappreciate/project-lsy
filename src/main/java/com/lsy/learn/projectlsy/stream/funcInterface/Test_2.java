package com.lsy.learn.projectlsy.stream.funcInterface;

import com.lsy.learn.projectlsy.stream.funcInterface.dto.Person;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Supplier<T> 供给型接口
 */
public class Test_2 {
    public static void main(String[] args) {
        //--------------------------
        new Test_2().test1(() -> {
            Person person = new Person();
            person.setAge(1);
            person.setName("yanhui");
            return person;
        });
        //--------------------------
    }


    public <T> void test1(Supplier<T> supplier) {
        T t = supplier.get();
        System.out.println(t);
    }

}
