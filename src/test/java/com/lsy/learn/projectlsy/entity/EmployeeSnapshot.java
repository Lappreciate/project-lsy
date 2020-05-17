package com.lsy.learn.projectlsy.entity;

import java.util.List;

public class EmployeeSnapshot {
    private long id;
    private String name;
    private Integer age;

    private List<String> hobby;

    public EmployeeSnapshot(long id, String name, Integer age, List<String> hobby) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }
}
