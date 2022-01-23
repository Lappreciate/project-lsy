package com.lsy.learn.projectlsy.stream.funcInterface.dto;

import lombok.Data;

@Data
public class Person {

    public Person() {

    }

    public Person(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    private String name;
    private int age;
    private int score;
}
