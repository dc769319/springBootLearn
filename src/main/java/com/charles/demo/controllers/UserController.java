package com.charles.demo.controllers;

import com.charles.demo.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/users")
public class UserController {

    //线程安全的map
    private static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        //Restful形式，Get方法访问/users，返回用户信息列表
        return new ArrayList<>(users.values());
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user) {
        // 处理/users，POST方法，用来创建User
        users.put(user.getId(), user);
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return users.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable Long id, @ModelAttribute User user) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        User u = users.get(id);
        if (null == u) {
            return "Invalid param id";
        }
        String name = user.getName();
        Integer age = user.getAge();
        if (null != name) {
            u.setName(user.getName());
        }
        if (null != age && 0 != age) {
            u.setAge(user.getAge());
        }
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        users.remove(id);
        return "success";
    }

    /**
     * 访问/users/hello时，方法抛出异常，这时会调用全局异常处理方法
     * @throws Exception 执行时异常
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public void hello() throws Exception {
        throw new Exception("发生错误");
    }
}
