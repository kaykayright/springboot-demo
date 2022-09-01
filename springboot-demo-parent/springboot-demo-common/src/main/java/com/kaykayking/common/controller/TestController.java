package com.kaykayking.common.controller;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 2:49 下午 2022/7/27.
 * @Modified By:
 */

import com.kaykayking.common.config.CommonRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * todo
 *
 * @author hk
 * @version Id: TestController.java, v 0.1 2022/7/27 2:49 下午 Exp $$
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/log")
   public CommonRes testLog(){

        logger.debug("==============测试日志debug级别打印==================");
        logger.info("==============测试日志info级别打印==================");
        logger.error("==============测试日志error级别打印==================");
        logger.warn("==============测试日志warn级别打印==================");

        String website = "www.shiningshing.com";
        String sinaweibo = "shiningshing.weibo.com";

        logger.info("=======网站信息:{};微博地址:{}",website,sinaweibo);

        return CommonRes.create("success");


    }


}