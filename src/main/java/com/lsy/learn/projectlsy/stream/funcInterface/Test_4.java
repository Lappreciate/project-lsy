package com.lsy.learn.projectlsy.stream.funcInterface;

import com.lsy.learn.projectlsy.stream.funcInterface.dto.Person;

import java.util.function.Function;

public class Test_4 {

    public static void main(String[] args) {
        Person p = new Person();
        p.setName("yanhui");
        p.setAge(1);
        //--------------------------
        System.out.println(
                new Test_4().test1(
                        p,
                        person -> {
                            person.setName(person.getName() + "_1");
                            return person;
                        },
                        person -> {
                            person.setName(person.getName() + "_2");
                            return person;
                        })
        );
    }

    public <Person> Person test1(Person person, Function<Person, Person> function_1, Function<Person, Person> function_2) {
        Person res_person = function_1.andThen(function_2).apply(person);
        return res_person;
    }
}
