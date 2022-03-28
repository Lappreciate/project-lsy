package com.lsy.learn.projectlsy.controller;

import com.lsy.learn.projectlsy.grpcCilent.TestServiceGrpcClient;
import com.lsy.learn.projectlsy.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myController1")
@Slf4j
@Lazy
public class MyController1 implements ApplicationContextAware {


    @Autowired
    private TestService testService;

    private ApplicationContext applicationContext;


    @Autowired
    private TestServiceGrpcClient testServiceGrpcClient;

    @RequestMapping("/configTest1")
    public void func2() {
        log.info("bbbb");
    }

    @RequestMapping("/configTest")
    public void func1() {
        //grpc调用端
        log.info("res:{}", testServiceGrpcClient.getGrpcTest());
        log.info("bbbb");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    public static class A {
        private int a;
        private String B;
    }

}
