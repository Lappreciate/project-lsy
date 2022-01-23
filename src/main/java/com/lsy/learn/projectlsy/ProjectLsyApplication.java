package com.lsy.learn.projectlsy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

@Slf4j
@SpringBootApplication
public class ProjectLsyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ProjectLsyApplication.class, args);
        Object testCondition = null;
        try {
            testCondition = context.getBean("testBean_1");
        } catch (Exception e) {
            log.info("error------------------");
        }
        System.out.println(testCondition);
    }


}
