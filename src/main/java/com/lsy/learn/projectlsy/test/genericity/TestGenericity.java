package com.lsy.learn.projectlsy.test.genericity;

import com.lsy.learn.projectlsy.test.SupplierTest.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Yanhui
 * @date 2020/9/27 14:29
 */
public class TestGenericity<T> {

    private Supplier<List<T>> supplier;

    public TestGenericity(Supplier<List<T>> supplier) {
        this.supplier = supplier;
    }

    public List<T> getCount() {
        List<T> list = supplier.get();
        return list;
    }


    public static void main(String[] args) {
        new TestGenericity<>(() -> {
            List<Test.Person> list = new ArrayList<>();
            Test.Person person1 = new Test.Person();
            person1.setName("yanhui");
            person1.setAge(20);
            person1.setSex("man");
            list.add(person1);
            return list;
        }).getCount();
    }
}
