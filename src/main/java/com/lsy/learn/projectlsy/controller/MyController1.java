package com.lsy.learn.projectlsy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myController1")
public class MyController1 {

    @RequestMapping("/func1")
    public void func1(){
        System.out.println("MyController1------------------");
    }
}
