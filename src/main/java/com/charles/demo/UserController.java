package com.charles.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Charles
 * @version 1.0
 */
@RestController
public class UserController {

    public UserController() {
    }

    @Autowired
    PeopleBean peopleBean;

    @Autowired
    DbConf dbConf;

    @RequestMapping("/username")
    public String name() {
        return "Hello, " + peopleBean.getFirstName() + peopleBean.getLastName();
    }

    @RequestMapping("/connection")
    public String connection() {
        return "Host:" + dbConf.getHost() + ", Username:" + dbConf.getUsername() + ", Password:" + dbConf.getPassword();
    }
}
