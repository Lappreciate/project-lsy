package com.lsy.learn.projectlsy.stream.funcInterface;

import com.lsy.learn.projectlsy.stream.funcInterface.dto.Person;

import java.util.function.Function;

/**
 * Function<T,R> 函数式接口
 */
public class Test_3 {

    public static void main(String[] args) {

        Person p = new Person();
        p.setName("yanhui");
        p.setAge(1);
        //--------------------------
        new Test_3().test1(p, (person -> {
            person.setAge(100);
            person.setName("yanhui123");
            return person;
        }));
        //--------------------------
    }

    public void test1(Person person, Function<Person, Person> function) {

        System.out.println(person);
        Person result = function.apply(person);
        System.out.println(result);
    }

}
