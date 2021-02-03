package com.lsy.learn.projectlsy.designModel;

/**
 * @author Yanhui
 * @date 2020/12/26 11:20
 */
public class MyTest {
    public static void main(String[] args) {
        PersonAbs person1 = new PersonA();
        PersonAbs person2 = new PersonB();

        person1.tellMeYouAge();
        person2.tellMeYouAge();
    }
}
