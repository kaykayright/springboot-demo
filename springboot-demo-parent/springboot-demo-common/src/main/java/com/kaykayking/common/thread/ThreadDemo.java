package com.kaykayking.common.thread;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 7:51 下午 2022/8/12.
 * @Modified By:
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * todo
 *
 * @author hk
 * @version Id: ThreadDemo.java, v 0.1 2022/8/12 7:51 下午 Exp $$
 */
public class ThreadDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        CompletableFuture<String> fature = new CompletableFuture<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("CompletableFuture 可以监控这个任务的执行");
                fature.complete("任务返回结果");
            }
        }).start();
        System.out.println(fature.get());


    }
}