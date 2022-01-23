package com.lsy.learn.projectlsy.stream.funcInterface;

import com.lsy.learn.projectlsy.stream.funcInterface.dto.Person;
import lombok.Data;

import java.util.function.Consumer;

/**
 * Consumer<T>
 * void accept(T t);
 * 对参数进行处理（展示 修改 等操作，但是不需要返回值）
 */
public class Test_1 {
    public static void main(String[] args) {
        Person person = new Person();

        System.out.println(person);
        //--------------------------
        new Test_1().test1(person, x -> {
            person.setAge(1);
            person.setName("yanhui");
        });
        //--------------------------
        System.out.println(person);
    }


    public void test1(Person val, Consumer<Person> consumer) {
        consumer.accept(val);
    }



}
