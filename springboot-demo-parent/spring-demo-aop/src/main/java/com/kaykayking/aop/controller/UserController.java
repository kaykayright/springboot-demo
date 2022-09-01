package com.kaykayking.aop.controller;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 10:40 上午 2022/7/29.
 * @Modified By:
 */

import com.kaykayking.aop.pojo.User;
import com.kaykayking.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * todo
 *
 * @author hk
 * @version Id: UserController.java, v 0.1 2022/7/29 10:40 上午 Exp $$
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/print")
    @ResponseBody
    public User printUser(){

        User user = new User("kaykayking",18);
        userService.printUser(user);
        return user;

    }
}