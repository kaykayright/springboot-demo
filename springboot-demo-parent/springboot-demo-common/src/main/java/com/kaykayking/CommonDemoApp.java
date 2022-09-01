package com.kaykayking;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 9:57 下午 2022/7/26.
 * @Modified By:
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * todo
 *
 * @author hk
 * @version Id: CommonDemoApp.java, v 0.1 2022/7/26 9:57 下午 Exp $$
 */
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class CommonDemoApp {

    public static void main(String[] args) {
        SpringApplication.run(CommonDemoApp.class,args);
    }
}