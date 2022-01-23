package com.lsy.learn.projectlsy.stream.complexList;

import com.lsy.learn.projectlsy.stream.complexList.collect.MyCollector;
import com.lsy.learn.projectlsy.stream.funcInterface.dto.Person;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo1 {
    public static void main(String[] args) {
        Person person_1 = new Person("yanhui", 18, 100);
        Person person_2 = new Person("lilei", 19, 99);
        Person person_3 = new Person("hanmeimei", 18, 98);
        Person person_4 = new Person("yanhui", 19, 90);
        Person person_5 = new Person("lilei", 19, 78);
        Person person_6 = new Person("yanhui", 20, 66);
        Person person_7 = new Person("hanmeimei", 21, 120);
        Person person_8 = new Person("yanhui", 20, 130);
        Person person_9 = new Person("lilei", 21, 119);
        Person person_0 = new Person("yanhui", 19, 22);
        Person person_10 = new Person("hanmeimei", 18, 98);

        List<Person> list = new ArrayList<>();
        list.add(person_1);
        list.add(person_2);
        list.add(person_3);
        list.add(person_4);
        list.add(person_5);
        list.add(person_6);
        list.add(person_7);
        list.add(person_8);
        list.add(person_9);
        list.add(person_0);
        list.add(person_10);
//        new Demo1().func_group(list);
//        new Demo1().func_count(list);
//        new Demo1().func_min_max(list);
//        new Demo1().func_summary(list);
//        new Demo1().func_joining(list);
        new Demo1().func_myCollector(list);
    }

    public void func_group(List<Person> personList) {
        Map<String, List<Person>> map_group_1 = personList.stream().collect(Collectors.groupingBy(Person::getName));
        Iterator<Map.Entry<String, List<Person>>> iterator = map_group_1.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Person>> next = iterator.next();
            System.out.println(next.getKey() + ":" + next.getValue());
        }

        System.out.println("=====================");

        Map<String, Map<String, List<Person>>> collect = personList.stream().collect(Collectors.groupingBy(Person::getName, Collectors.groupingBy(person -> {
            if (person.getAge() > 5) {
                return "big";
            } else {
                return "small";
            }
        })));
        System.out.println(collect);

        System.out.println("=====================");

        Map<String, Long> collect_2 = personList.stream().collect(Collectors.groupingBy(Person::getName, Collectors.counting()));
        System.out.println(collect_2);

        System.out.println("=====================");

        Map<String, Map<Integer, Long>> collect3 = personList.stream().collect(Collectors.groupingBy(Person::getName, Collectors.groupingBy(Person::getAge, Collectors.counting())));
        System.out.println(collect3);


        System.out.println("=====================");

        Map<String, Person> collect4 = personList.stream().collect(
                Collectors.groupingBy(p -> p.getName() + "_" + p.getAge(), Collectors.collectingAndThen(
                        Collectors.maxBy(
                                Comparator.comparing(Person::getAge))
                        , Optional::get
                )));
        //toMap写法
        Map<String, Person> collect5 = personList.stream().collect(
                Collectors.toMap(p -> p.getName() + "_" + p.getAge(), Function.identity(), BinaryOperator.maxBy(Comparator.comparing(Person::getAge))));

        System.out.println(collect4);


    }

    public void func_count(List<Person> personList) {
        Long collect = personList.stream().count();
        System.out.println(collect);
        System.out.println("===============");
    }

    public void func_min_max(List<Person> personList) {
        Optional<Person> collect_max = personList.stream().max(Comparator.comparing(Person::getAge));
        Optional<Person> collect_min = personList.stream().min(Comparator.comparing(Person::getAge));
        collect_max.ifPresent(System.out::println);
        collect_min.ifPresent(System.out::println);
    }

    public void func_summary(List<Person> personList) {
        IntSummaryStatistics collect = personList.stream().collect(Collectors.summarizingInt(Person::getAge));
        System.out.println(collect.getMax());
        System.out.println(collect.getSum());
        System.out.println(collect.getAverage());
    }

    public void func_joining(List<Person> personList) {
        String collect = personList.stream().map(Person::getName).collect(Collectors.joining(","));
        String collect_1 = personList.stream().map(Person::getName).collect(Collectors.joining(",", "[", "]"));
        String collect_2 = personList.stream().map(p -> p.getAge() + "").collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);
        System.out.println(collect_1);
        System.out.println(collect_2);
    }


    public void func_myCollector(List<Person> personList) {
        List<Person> collect = personList.stream().collect(new MyCollector());
        System.out.println(collect);

    }
}
