package com.lsy.learn.projectlsy.controller;

import com.lsy.learn.projectlsy.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myController1")
public class MyController1 {

    @Autowired
    TestService testService;

    @RequestMapping("/func1")
    public void func1(){
        System.out.println("MyController1------------------");
        testService.test();
    }
}
