package com.kaykayking;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 9:39 上午 2022/7/29.
 * @Modified By:
 */

import com.kaykayking.aop.aspect.MyAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * todo
 *
 * @author hk
 * @version Id: AopStarterApp.java, v 0.1 2022/7/29 9:39 上午 Exp $$
 */
@SpringBootApplication
public class AopStarterApp {

    @Bean(name = "myAspect")
    public MyAspect initMyAspect(){
        return new MyAspect();
    }

    public static void main(String[] args) {
        SpringApplication.run(AopStarterApp.class,args);
    }
}