package com.charles.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Charles
 * @version 1.0
 */
@RestController
public class ArticleController {

    @Autowired
    ArticleBean articleBean;

    @RequestMapping("/article")
    public String show() {
        return articleBean.getTitle() + ", " + articleBean.getDesc() + ", " + articleBean.getUuid();
    }
}