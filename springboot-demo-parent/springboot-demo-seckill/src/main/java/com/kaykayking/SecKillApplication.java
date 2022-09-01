package com.kaykayking;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 12:21 下午 2022/8/13.
 * @Modified By:
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * todo
 *
 * @author hk
 * @version Id: SecKillApplication.java, v 0.1 2022/8/13 12:21 下午 Exp $$
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.kaykayking.seckill.dao"})
@EnableScheduling
public class SecKillApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecKillApplication.class,args);
    }
}