package com.charles.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Charles
 * @version 1.0
 */
@ConfigurationProperties(prefix = "default")
public class PeopleBean {
    private String name;
    private int sex;
    private String firstName;
    private String lastName;
    private String fullName;

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
