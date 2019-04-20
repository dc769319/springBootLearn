package com.charles.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Charles
 * @version 1.0
 */
@ConfigurationProperties(prefix = "db")
public class DbConf {
    private String host;
    private String username;
    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
