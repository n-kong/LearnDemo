package com.nkong.Thread;

import java.util.concurrent.*;

/**
 * @Author: nkong
 * @Date: 2020/5/24 21:50
 * @Version 1.0
 */
public class ThreadPool01 {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            int tmp = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ": " + tmp);
                }
            });
        }
        // 停止线程
        executor.shutdown();

    }

    public void t() {
        // 1核心线程数  2最大线程数  3线程存活时间  4时间单位  5线程池队列大小
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));
    }

}
