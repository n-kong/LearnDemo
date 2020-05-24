package com.nkong.Thread;

/**
 * @Author: nkong
 * @Date: 2020/5/24 14:41
 * @Version 1.0
 */
public class ThreadSafety02 {

    public static void main(String[] args) {
        ThreadDemo02 threadDemo02 = new ThreadDemo02();
        ThreadDemo02 threadDemo021 = new ThreadDemo02();
        Thread t1 = new Thread(threadDemo02, "窗口1");
        Thread t2 = new Thread(threadDemo021, "窗口2");
        t1.start();
        t2.start();
    }

}

class ThreadDemo02 implements Runnable {

    private static int count = 100;
    private static Object obj = new Object();

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

    public void sale() {
        synchronized (obj) {
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + ",出售" + (100 - count + 1) + "车票");
                count--;
            }
        }
    }
}