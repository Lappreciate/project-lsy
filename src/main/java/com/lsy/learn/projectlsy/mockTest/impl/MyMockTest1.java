package com.lsy.learn.projectlsy.mockTest.impl;

import com.lsy.learn.projectlsy.mockTest.MockTestJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class MyMockTest1 implements MockTestJdbc {

    final String sql = "select * from stu_info";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void test() {
        List<Map<String, Object>> dataList = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : dataList) {
            Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> entry = iterator.next();
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }
        }
    }
}
