package com.kaykayking.aop.proxy;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 9:08 上午 2022/7/29.
 * @Modified By:
 */

import com.kaykayking.aop.intercept.Interceptor;
import com.kaykayking.aop.invoke.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * todo
 *
 * @author hk
 * @version Id: ProxyBean.java, v 0.1 2022/7/29 9:08 上午 Exp $$
 */
public class ProxyBean implements InvocationHandler {

    private Object target = null;
    private Interceptor interceptor = null;


    /**
     * 绑定代理对象
     * @param target 被代理对象
     * @param interceptor 拦截器
     * @return 代理对象
     */
    public static Object getProxyBean(Object target,Interceptor interceptor){

        ProxyBean proxyBean = new ProxyBean();

        proxyBean.target = target;

        proxyBean.interceptor = interceptor;

        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),
                proxyBean);

        return proxy;

    }

    /**
     * 处理代理对象方法逻辑
     * @param proxy 代理对象
     * @param method 当前方法
     * @param args 运行参数
     * @return 方法调用结果
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //异常标识
        boolean exceptionFlag = false;
        Invocation invocation = new Invocation(target,method,args);
        Object retObj = null;
        try{
            if(this.interceptor.before()){
                retObj = this.interceptor.around(invocation);
            }else{
                retObj = method.invoke(target,args);
            }
        } catch (Exception ex){
            exceptionFlag = true;
        }
        this.interceptor.after();
        if(exceptionFlag){
            this.interceptor.afterThrowing();
        }else{
            this.interceptor.afterReturning();
            return retObj;
        }


        return null;
    }
}