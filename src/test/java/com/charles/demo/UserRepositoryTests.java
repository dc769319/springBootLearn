package com.charles.demo;

import com.charles.demo.entities.User;
import com.charles.demo.entities.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void run(){
        userRepository.save(new User("XiaoQi", 2));
        userRepository.save(new User("FaFa", 3));
        userRepository.save(new User("TaoTao", 26));

        //测试FindAll
        Assert.assertEquals(3, userRepository.findAll().size());
        Assert.assertEquals(2, userRepository.findByName("XiaoQi").getAge().intValue());

        Assert.assertEquals("TaoTao", userRepository.findByNameAndAge("TaoTao", 26).getName());
        Assert.assertEquals("FaFa", userRepository.findUser("FaFa").getName());


    }
}
