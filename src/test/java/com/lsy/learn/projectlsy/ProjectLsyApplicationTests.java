package com.lsy.learn.projectlsy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
class ProjectLsyApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;
    final String sql = "select * from stu_info";

    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource);
        System.out.println(dataSource.getConnection());
        System.out.println(jdbcTemplate);
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list.stream().count());
        List<Map<String, Object>> list1 = list.stream().filter(l -> !l.get("name").equals("liushengyuan")).collect(Collectors.toList());
        System.out.println(list1);
    }

}
