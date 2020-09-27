package com.lsy.learn.projectlsy.test;

import com.lsy.learn.projectlsy.entity.EmployeeSnapshot;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StreamTest {
    static List<EmployeeSnapshot> employeeList = null;
    static List<Map<String, String>> mapList = null;

    static {
        employeeList = Arrays.asList(
                new EmployeeSnapshot(1L, "wanghailiang", 29, Arrays.asList("pingpong", "swimming")),
                new EmployeeSnapshot(2L, "liushengyuan", 18, Arrays.asList("basketball", "game")),
                new EmployeeSnapshot(3L, "zhangjing", 21, Arrays.asList("pingpong", "football")),
                new EmployeeSnapshot(4L, "zhangwenyuan", 29, Arrays.asList("soccer", "swimming")),
                new EmployeeSnapshot(5L, "dashan", 50, Arrays.asList("pingpong", "swimming")),
                new EmployeeSnapshot(6L, "erik", 29, Arrays.asList("123213213", "swimming")),
                new EmployeeSnapshot(7L, "daofeng", 32, Arrays.asList("pingpong", "654654654")),
                new EmployeeSnapshot(8L, "smile", 24, Arrays.asList("lllllll", "swimming")));

        mapList = new ArrayList<>();
        Map<String, String> exampleMap1 = new HashMap<>();
        Map<String, String> exampleMap2 = new HashMap<>();
        Map<String, String> exampleMap3 = new HashMap<>();
        Map<String, String> exampleMap4 = new HashMap<>();
        exampleMap1.put("num", "111111");
        exampleMap2.put("num", "22222");
        exampleMap3.put("num", "33333");
        exampleMap4.put("num", "44444");
        mapList.add(exampleMap1);
        mapList.add(exampleMap2);
        mapList.add(exampleMap3);
        mapList.add(exampleMap4);
    }


    @Test
    void stream() {
        List<EmployeeSnapshot> employeeSnapshots = employeeList.stream()
                .filter(e -> e.getAge() > 25)
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .collect(Collectors.toList());
        employeeSnapshots.forEach(employeeSnapshot -> {
            System.out.println(employeeSnapshot.getId() + " " + employeeSnapshot.getName() + " " + employeeSnapshot.getAge());
        });
    }

    @Test
    void test() {
        /**
         * map
         */
//        Stream<Integer> sm = employeeList.stream().map(EmployeeSnapshot::getAge);
//        sm.forEach(System.out::println);
        /**
         * flatMap
         */
//        Stream<String> stream = employeeList.stream().flatMap(employeeSnapshot -> employeeSnapshot.getHobby().stream());
//        List<String> list = stream.collect(Collectors.toList());
//        stream.forEach(System.out::println);
//
//        System.out.println("-----------------------------------");
//        Stream<List<String>> sm = employeeList.stream().map(EmployeeSnapshot::getHobby);
//        sm.forEach(System.out::println);

        /**
         * reduce
         */
//        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        Optional<Integer> sum = numberList.stream().reduce((x, y) -> x + y);

//        Integer sum = numberList.stream().reduce(0, (x, y) -> x + y);
//        System.out.println(sum);

//        Integer ageSum = employeeList.stream().map(EmployeeSnapshot::getAge).reduce(0, Integer::sum);
//        System.out.println(ageSum);

//        List<String> list = mapList.stream().map(x -> x.get("num")).collect(Collectors.toList());
//        list.forEach(System.out::println);

        /**
         * 分组
         */
//        Map<Integer, List<EmployeeSnapshot>> map = employeeList.stream().collect(Collectors.groupingBy(EmployeeSnapshot::getAge));
//        System.out.println(map);
        /**
         * 多级分组
         */
//        Map<Integer, Map<String, List<EmployeeSnapshot>>> map = employeeList.stream().collect(Collectors.groupingBy(EmployeeSnapshot::getAge, Collectors.groupingBy(EmployeeSnapshot::getName)));
//        System.out.println(map);

        /**
         * 分区partition
         */
//        Map<Boolean, List<EmployeeSnapshot>> list = employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));
//        System.out.println(list);

        /**
         * 统计 Collectors.summarizingDouble   Collectors.summarizingInt()   Collectors.summarizingLong()
         */

//        DoubleSummaryStatistics statistics = employeeList.stream().collect(Collectors.summarizingDouble(e -> e.getAge()));
//        System.out.println(statistics.getMax());
//        System.out.println(statistics.getAverage());
//        System.out.println(statistics.getCount());
//        System.out.println(statistics.getMin());
//        System.out.println(statistics.getSum());

        /**
         * join连接
         */

//        String str = mapList.stream().map(e -> e.get("num")).collect(Collectors.joining(",","start: "," :end"));
//        System.out.println(str);

        boolean all = employeeList.stream().allMatch(user -> user.getAge() > 25);
        System.out.println(all);
        boolean any = employeeList.stream().anyMatch(user -> user.getAge() > 25);
        System.out.println(any);
        boolean noneMatch = employeeList.stream().noneMatch(user -> user.getAge() > 25);
        System.out.println(noneMatch);

        Optional<EmployeeSnapshot> employeeSnapshot = employeeList.stream().sorted((o1, o2) -> o2.getAge() - o1.getAge()).findFirst();
        System.out.println(employeeSnapshot.get().getName());
    }


}


