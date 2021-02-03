package com.lsy.learn.projectlsy.test.SupplierTest;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Yanhui
 * @date 2020/9/27 11:39
 */
public class Test {
    public static void main(String[] args) {
        testConsumer(p -> {
            if (p.getName() == "yanhui") {
                p.setName("junmo");
            } else {
                p.setName("dashan");
            }
            System.out.println(p.getName());
        }, p -> {
            if (p.getName() == "yanhui") {
                p.setName("junmo");
            } else {
                p.setName("dashan");
            }
            System.out.println(p.getName());
        });

//        System.out.println(testSupplier(() -> 1));
    }

    public static void testConsumer(Consumer<Person> consumer, Consumer<Person> consumer1) {
        Person person = new Person();
        person.setName("yanhui");
        person.setAge(19);
        person.setSex("man");
        consumer.andThen(consumer1).accept(person);
    }

    public static Integer testSupplier(Supplier<Integer> supplier) {
        return supplier.get();
    }

    public static void testFunction() {
        Person person = new Person();
        Function<Person, Integer> function = x -> x.getAge();
        System.out.println(function.apply(person));
//        return function.apply();
    }


    public static class Person {
        private String name;
        private int age;
        private String sex;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", sex='" + sex + '\'' +
                    '}';
        }
    }
}
