package com.charles.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Charles
 * @version 1.0
 */
@ConfigurationProperties(prefix = "article")
public class ArticleBean {
    private String title;
    private String desc;
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
