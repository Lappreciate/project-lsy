package com.lsy.learn.projectlsy.service;

import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class TestService {

    long time = System.currentTimeMillis();

    public void test() {
        System.out.println(time);
    }

    public void printMethod() {
        getStackInfo();
    }

    private String getStackInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String stackInfo = "none";
        Stack<String> stackInfoList = new Stack<>();
        try {
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement.getClassName().contains("com.lsy.learn") && !stackTraceElement.getMethodName().equalsIgnoreCase("getStackInfo")) {
                    stackInfoList.push(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName());
                }
            }
            while (stackInfoList.size() > 0) {
                if (stackInfoList.size() == 1) {
                    stackInfo += stackInfoList.pop();
                } else {
                    stackInfo += stackInfoList.pop() + " -> ";
                }
            }
        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
        }
        return stackInfo;
    }
}
