package com.lsy.learn.projectlsy.test;


import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("---" + rewardConfig);
    }


    public static Map<String, Integer> rewardMapping = new HashMap<>();

    public static final Map<Integer, Map<String, Integer>> rewardConfig = new HashMap<>();


    static {
        // 1
        rewardConfig.put(1, rewardMapping);

        // 2
        Map<String, Integer> newMap = new HashMap();
        newMap.put("1", 22);
        rewardMapping = newMap;
    }

}
