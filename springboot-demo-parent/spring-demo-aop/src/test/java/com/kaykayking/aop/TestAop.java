package com.kaykayking.aop;


import com.kaykayking.aop.intercept.MyInterceptor;
import com.kaykayking.aop.pojo.User;
import com.kaykayking.aop.proxy.ProxyBean;
import com.kaykayking.aop.service.HelloService;
import com.kaykayking.aop.service.UserService;
import com.kaykayking.aop.service.impl.HelloServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestAop {

    @Autowired
    private UserService userService;


    @Test
    public void testProxyt(){
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService,new MyInterceptor());
    }


    @Test
    public void testPointCut(){

        User user = new User("kaykayking",10);
        userService.printUser(user);




    }



}
