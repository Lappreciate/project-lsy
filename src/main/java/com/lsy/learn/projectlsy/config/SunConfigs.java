package com.lsy.learn.projectlsy.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Yanhui
 * @date 2021/1/26 9:57
 */
@Configuration
public class SunConfigs {


    @Value("testValue")
    public static int a;
    public String s;

//    public int getA() {
//        return a;
//    }
//
//    public void setA(int a) {
//        this.a = a;
//    }
//
//    public String getS() {
//        return s;
//    }
//
//    public void setS(String s) {
//        this.s = s;
//    }

    public SunConfigs() {
        a = 19999;
        s = "19999";
    }

    @Value("${config.environment}")
    public String configEnvironment;

    @PostConstruct
    private void configInitialization() {

        System.out.println("@PostConstruct------------------" + a);
        System.out.println(configEnvironment);
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("implements InitializingBean afterPropertiesSet--------------");
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        applicationContext.getBean(ApplicationConfig.class);
//        System.out.println("implements ApplicationContextAware setApplicationContext");
//    }


}
