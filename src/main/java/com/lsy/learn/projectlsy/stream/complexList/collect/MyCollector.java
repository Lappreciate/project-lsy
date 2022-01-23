package com.lsy.learn.projectlsy.stream.complexList.collect;

import com.lsy.learn.projectlsy.stream.funcInterface.dto.Person;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MyCollector implements Collector<Person, List<Person>, List<Person>> {

    @Override
    public Supplier<List<Person>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Person>, Person> accumulator() {
        return (studentList, student) -> {
            if (student.getScore() < 100) {
                studentList.add(student);
            }
        };
    }

    @Override
    public BinaryOperator<List<Person>> combiner() {
        return null;
    }

    @Override
    public Function<List<Person>, List<Person>> finisher() {
        return personList -> {
            for (Person p : personList) {
                p.setName(p.getName() + "_*");
            }
            return personList;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        //代表跳过finisher
        return EnumSet.of(Characteristics.IDENTITY_FINISH);
    }
}
