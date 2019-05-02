package com.charles.demo.services;

public interface UserService {
    void create(String name, Integer age);

    void deleteByName(String name);

    Integer getUserCount();

    boolean update(Integer id, String name, Integer age);
}
