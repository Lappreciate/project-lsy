package com.lsy.learn.projectlsy.mockTest;


import com.lsy.learn.projectlsy.mockTest.MockTestJdbc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockTest {

    @MockBean
    JdbcTemplate jdbcTemplate;
    final String sql = "select * from stu_info";

    @Autowired
    MockTestJdbc mockTestJdbc;

    @Test
    public void mockTest1() {

        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "11111111");
        map.put("subject", "222222");
        map.put("school", "33333");
        map.put("score", "555555");
        map.put("createTime", "777777");
        dataList.add(map);

        Mockito.when(
                jdbcTemplate.queryForList(
                        Mockito.anyString()
                )
        ).thenReturn(dataList);

        mockTestJdbc.test();

    }
}
