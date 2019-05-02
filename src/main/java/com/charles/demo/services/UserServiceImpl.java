package com.charles.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * 添加了Service注解，标注为业务层组件（Component）。该对象会被注入到IOC容器中
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(String name, Integer age) {
        jdbcTemplate.update("INSERT INTO `user` (`name`, `age`) VALUES (?, ?)", name, age);
    }

    public void deleteByName(String name) {
        jdbcTemplate.update("DELETE FROM `user` WHERE `name` = ?", name);
    }

    public Integer getUserCount() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM `user`", Integer.class);
    }

    public boolean update(Integer id, String name, Integer age) {
        int affectRows = jdbcTemplate.update("UPDATE `user` SET `name` = ?, `age` = ? WHERE id = ?", name, age, id);
        return (affectRows > 0) ? true : false;
    }
}
