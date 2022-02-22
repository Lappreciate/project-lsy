package com.lsy.learn.projectlsy.test.SupplierTest;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
//    public static int a = 1;
    public static final int b = 1;
    public static final Map<String, Integer> map;

    static {
        System.out.println("static" + 1);
        map = new HashMap<>();
        map.put("1", 1);
    }
}
