package com.charles.demo;

import com.charles.demo.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTests {

    @Autowired
    private UserService userService;

    @Test
    public void run() {
        //添加新用户
        userService.create("Charles", 29);
        userService.create("Boll", 24);
        userService.create("Jim", 25);
        userService.create("Lily", 30);
        userService.create("Cherry", 29);

        //查用户数量
        Assert.assertEquals(5, userService.getUserCount().intValue());

        //删除一个用户
        userService.deleteByName("Jim");

        //更新一个用户
        Assert.assertTrue(userService.update(2, "Billy", 35));

        Assert.assertEquals(4, userService.getUserCount().intValue());


    }
}
