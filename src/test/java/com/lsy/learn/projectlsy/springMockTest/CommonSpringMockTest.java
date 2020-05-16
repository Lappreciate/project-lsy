package com.lsy.learn.projectlsy.mockTest;

import com.lsy.learn.projectlsy.mockTest.impl.MyMockTest1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonSpringMockTest {

    @MockBean
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MyMockTest1 mockTest1;

    @Before
    public void setUp() {
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
