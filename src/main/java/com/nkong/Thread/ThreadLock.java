package com.nkong.Thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: nkong
 * @Date: 2020/5/30 21:21
 * @Version 1.0
 */
public class ThreadLock {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadLock.class);
    private static Map<String, String> cache = new HashMap();

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

    public void set(String key, String value) {
        try {
            writeLock.lock();
            LOGGER.info("开始写入 key:{}, value:{}", key, value);
            cache.put(key,value);
            Thread.sleep(500);
            LOGGER.info("写入 key:{}, value:{} 结束", key, value);
        } catch (Exception e) {

        } finally {
            writeLock.unlock();
        }
    }

    public void get(String key) {
        try {
            readLock.lock();
            LOGGER.info("开始读取 key:{}", key);
            String value = cache.get(key);
            Thread.sleep(500);
            LOGGER.info("读取完成 key:{}, value:{} 结束", key, value);
        } catch (Exception e) {

        } finally {
            readLock.unlock();
        }
    }
    public static void main(String[] args) {

        ThreadLock threadLock = new ThreadLock();
        Thread w = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    threadLock.set("i"+i, i + "");
                }
            }
        });

        Thread r = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    threadLock.get("i" + i);
                }
            }
        });

        w.start();
        r.start();

    }
}
