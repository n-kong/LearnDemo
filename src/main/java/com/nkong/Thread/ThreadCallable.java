package com.nkong.Thread;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.acl.LastOwnerException;
import java.util.concurrent.*;

/**
 * @Author: nkong
 * @Date: 2020/5/29 21:49
 * @Version 1.0
 */
public class ThreadCallable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadCallable.class);

    private static String s = "";

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> submit = executor.submit(new TaskFuture());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    LOGGER.info("main start running...");
                    s = submit.get();
                    LOGGER.info("s is {}", s);
                    executor.shutdown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        LOGGER.info("result is {}", s);
    }

}

class TaskFuture implements Callable<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskFuture.class);

    @Override
    public String call() throws Exception {
        LOGGER.debug("Start running");
        Thread.sleep(5000);
        LOGGER.error("Stop");
        return "thread run success!";
    }
}