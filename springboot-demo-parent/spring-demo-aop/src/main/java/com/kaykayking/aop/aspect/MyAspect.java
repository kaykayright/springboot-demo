package com.kaykayking.aop.aspect;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 10:14 上午 2022/7/29.
 * @Modified By:
 */

import org.aspectj.lang.annotation.*;

/**
 * todo
 *
 * @author hk
 * @version Id: MyAspect.java, v 0.1 2022/7/29 10:14 上午 Exp $$
 */
@Aspect
public class MyAspect {

    @Pointcut("execution(* com.kaykayking.aop.service.impl.UserServiceImpl.printUser(..))")
    public void pointCut(){

    }


    @Before("execution(* com.kaykayking.aop.service.impl.UserServiceImpl.printUser(..))")
    public void before(){
        System.out.println("before ......");
    }

    @After("execution(* com.kaykayking.aop.service.impl.UserServiceImpl.printUser(..))")
    public void after(){
        System.out.println("after ......");
    }

    @AfterReturning("execution(* com.kaykayking.aop.service.impl.UserServiceImpl.printUser(..))")
    public void afterReturning(){
        System.out.println("afterRuturning ......");
    }

    @AfterThrowing("execution(* com.kaykayking.aop.service.impl.UserServiceImpl.printUser(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing......");
    }


}