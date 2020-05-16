package com.lsy.learn.projectlsy.mockTest;

import com.lsy.learn.projectlsy.mockTest.impl.MyMockTest1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class CommonMockTest {

    private JdbcTemplate jdbcTemplate;

    private MyMockTest1 mockTest1;

    @Before
    public void setUp() {
        this.jdbcTemplate = Mockito.mock(JdbcTemplate.class);
        this.mockTest1 = new MyMockTest1();
        ReflectionTestUtils.setField(mockTest1, "jdbcTemplate", jdbcTemplate);
    }

    @Test
    public void test1() {

        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "11111111");
        map.put("subject", "222222");
        map.put("school", "33333");
        map.put("score", "555555");
        map.put("createTime", "777777");
        dataList.add(map);

        Mockito.when(jdbcTemplate.queryForList(anyString())).thenReturn(dataList);
        mockTest1.test();
    }
}
