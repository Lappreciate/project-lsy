package com.lsy.learn.projectlsy.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class StreamTest {

    List<EmployeeSnapshot> employeeList = Arrays.asList(
            new EmployeeSnapshot(1L, "wanghailiang", 29),
            new EmployeeSnapshot(2L, "liushengyuan", 18),
            new EmployeeSnapshot(3L, "zhangjing", 21),
            new EmployeeSnapshot(4L, "zhangwenyuan", 29),
            new EmployeeSnapshot(5L, "dashan", 50),
            new EmployeeSnapshot(6L, "erik", 29),
            new EmployeeSnapshot(7L, "daofeng", 32),
            new EmployeeSnapshot(8L, "smile", 24));

    @Test
    void stream() {
        List<EmployeeSnapshot> employeeSnapshots = employeeList.stream()
                .filter(e -> e.getAge() > 25)
                .sorted((o1, o2) -> o1.getAge() > o2.getAge() ? 1 : -1)
                .collect(Collectors.toList());
        employeeSnapshots.forEach(employeeSnapshot -> {
            System.out.println(employeeSnapshot.getId() + " " + employeeSnapshot.getName() + " " + employeeSnapshot.getAge());
        });
    }

    @Test
    void test() {
        System.out.println(Integer.compare(1, 2));
        System.out.println(Integer.compare(1, 1));
        System.out.println(Integer.compare(2, 1));
    }


}


class EmployeeSnapshot {
    private long id;
    private String name;
    private Integer age;

    public EmployeeSnapshot(long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
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
}
