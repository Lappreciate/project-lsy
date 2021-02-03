package com.lsy.learn.projectlsy.controller;

import com.lsy.learn.projectlsy.config.SunConfigs;
import com.lsy.learn.projectlsy.config.TotalConfigs;
import com.lsy.learn.projectlsy.designModel.PersonAbs;
import com.lsy.learn.projectlsy.service.TestService;
import com.lsy.learn.projectlsy.test.SupplierTest.Test;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
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
    private SunConfigs sunConfigs;
    @Autowired
    private TestService testService;


    private ApplicationContext applicationContext;

    @RequestMapping("/configTest")
    public void func1() {
        testService.printMethod();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


}
