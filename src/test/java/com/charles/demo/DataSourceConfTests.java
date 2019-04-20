package com.charles.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceConfTests {

    @Autowired
    private DataSourceConf dataSourceConf;

    @Test
    public void getConf() {
        Assert.assertEquals(
                dataSourceConf.getUrl(),
                "jdbc:mysql://127.0.0.1:3306/spring?useUnicode=true&characterEncoding=utf-8"
        );
    }
}
