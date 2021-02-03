package com.lsy.learn.projectlsy.designModel;

import org.springframework.stereotype.Service;

/**
 * @author Yanhui
 * @date 2020/12/26 11:07
 */
@Service
public class PersonB extends PersonAbs{
    @Override
    String myName() {
        return "b";
    }
}
