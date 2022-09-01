package com.kaykayking.common.controller;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 10:23 下午 2022/7/26.
 * @Modified By:
 */

import com.kaykayking.common.config.CommonError;
import com.kaykayking.common.config.CommonRes;
import com.kaykayking.common.config.EmBusinessError;
import com.kaykayking.common.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * todo
 *
 * @author hk
 * @version Id: JsonController.java, v 0.1 2022/7/26 10:23 下午 Exp $$
 */
@RestController
@RequestMapping("/json")
public class JsonController {

   @RequestMapping("/user")
   @ResponseBody
    public CommonRes getUser(){
        return CommonRes.create(new User(1l,"波多野结衣","123456"));
    }

    @RequestMapping("/error")
    @ResponseBody
    public CommonRes getUserError(){

       return CommonRes.create(new CommonError(EmBusinessError.NO_OBJECT_FOUND),"fail");
        //return CommonRes.create(new User(1l,"波多野结衣","123456"));
    }

    @RequestMapping("/list")
    @ResponseBody
    public CommonRes getUserList(){

       List<User> userList = new ArrayList<>();
       User user1 = new User(1l,"波多野结衣","123456");
        User user2 = new User(2l,"明日花绮罗","123456");
        User user3 = new User(null,"苍井空",null);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        return CommonRes.create(userList);


    }


}