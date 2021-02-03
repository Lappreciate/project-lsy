package com.lsy.learn.projectlsy.designModel;

/**
 * @author Yanhui
 * @date 2020/12/26 11:00
 */
public abstract class PersonAbs{


    public void tellMeYouAge(){
        System.out.println(myName());
    }

    abstract String myName();
}
