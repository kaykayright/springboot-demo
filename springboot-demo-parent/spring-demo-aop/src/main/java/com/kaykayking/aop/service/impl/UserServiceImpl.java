package com.kaykayking.aop.service.impl;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 10:04 上午 2022/7/29.
 * @Modified By:
 */

import com.kaykayking.aop.pojo.User;
import com.kaykayking.aop.service.UserService;
import org.springframework.stereotype.Service;

/**
 * todo
 *
 * @author hk
 * @version Id: UserServiceImpl.java, v 0.1 2022/7/29 10:04 上午 Exp $$
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public void printUser(User user) {

        if(user == null ){
            throw  new RuntimeException("检查用户参数是否为空");

        }
        System.out.println("name = "+ user.getName());
        System.out.println("age = " + user.getAge());

    }
}