package com.nkong.Thread;

/**
 * @Author: nkong
 * @Date: 2020/5/24 14:06
 * @Version 1.0
 */
public class ThreadSafety01 {
    public static void main(String[] args) {
        ThreadDemo01 threadDemo01 = new ThreadDemo01();
        Thread t1 = new Thread(threadDemo01, "窗口1");
        Thread t2 = new Thread(threadDemo01, "窗口2");
        t1.start();
        t2.start();
    }
}

class ThreadDemo01 implements Runnable {

    private int count = 100;

    @Override
    public void run() {
        try {
            while (count > 0) {
                Thread.sleep(500);
                sale();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void sale() {
        if (count > 0) {
            System.out.println(Thread.currentThread().getName() + ",出售" + (100 - count + 1) + "车票");
            count --;
        }
    }
}
