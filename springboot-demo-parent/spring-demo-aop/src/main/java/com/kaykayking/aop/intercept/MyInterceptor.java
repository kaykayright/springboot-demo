package com.kaykayking.aop.intercept;

import com.kaykayking.aop.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

public class MyInterceptor implements  Interceptor{


    @Override
    public boolean before() {

        System.out.println("before......");
        return false;
    }

    @Override
    public void after() {
        System.out.println("after......");


    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {

        System.out.println("around before ......");
        Object obj = invocation.proceed();
        System.out.println("around after......");
        return null;
    }

    @Override
    public void afterReturning() {
        System.out.println("after Retuning ......");

    }

    @Override
    public void afterThrowing() {

        System.out.println("after Throwing ......");


    }

    @Override
    public boolean useAround() {
        return true;
    }
}
