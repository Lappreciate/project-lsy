package com.lsy.learn.projectlsy.test.stream;

import java.util.*;

public class StreamTest {
    public static void main(String[] args) {

        /**
         * 方式1
         */
//        Comparator<Employee> com = new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                if (o1.getAge() > o2.getAge()) {
//                    return -1;
//                } else {
//                    return 1;
//                }
//            }
//        };

        /**
         * 方式2
         */
//        Comparator<Employee> com = (o1,o2)->{
//            if (o1.getAge() > o2.getAge()) {
//                return -1;
//            } else {
//                return 1;
//            }
//        };
//
//        TreeSet<Employee> treeSet = new TreeSet<>(com);

        /**
         * 方式3
         */
        TreeSet<Employee> treeSet = new TreeSet<>((o1, o2) -> {
            if (o1.getAge() > o2.getAge()) {
                return 1;
            } else {
                return -1;
            }
        });

        List<Employee> employeeList = Arrays.asList(
                new Employee(1L, "wanghailiang", 29),
                new Employee(2L, "liushengyuan", 18),
                new Employee(3L, "zhangjing", 21),
                new Employee(4L, "zhangwenyuan", 29),
                new Employee(5L, "dashan", 50),
                new Employee(6L, "erik", 29),
                new Employee(7L, "daofeng", 32),
                new Employee(8L, "smile", 24));

        treeSet.addAll(employeeList);

        for (Employee employee : treeSet) {
            System.out.println(employee.getName() + " ---- " + employee.getAge());
        }
    }


}


class Employee {
    private long id;
    private String name;
    private Integer age;

    public Employee(long id, String name, Integer age) {
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
