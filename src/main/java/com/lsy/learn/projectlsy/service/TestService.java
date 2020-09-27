package com.lsy.learn.projectlsy.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    long time = System.currentTimeMillis();

    public void test(){
        System.out.println(time);
    }
}
