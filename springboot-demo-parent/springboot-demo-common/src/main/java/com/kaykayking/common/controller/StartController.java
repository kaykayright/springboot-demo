package com.kaykayking.common.controller;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 9:59 下午 2022/7/26.
 * @Modified By:
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * todo
 *
 * @author hk
 * @version Id: StartController.java, v 0.1 2022/7/26 9:59 下午 Exp $$
 */
@RestController
@RequestMapping("/start")
public class StartController {


    @RequestMapping("/springboot")
    public String startSpringBoot(){

        return "Welcome to the world of Spring Boot!";


    }

}