package com.charles.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableConfigurationProperties({PeopleBean.class, ArticleBean.class, DbConf.class})
@RestController
@SpringBootApplication
public class DemoApplication {

    @Value("${default.name}")
    private String name;

    @Value("${default.sex}")
    private int sex;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "Hello world " + "Name:" + this.name + " Sex:" + this.sex;
    }

}
