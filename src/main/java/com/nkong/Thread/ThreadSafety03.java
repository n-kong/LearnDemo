package com.nkong.Thread;

/**
 * @Author: nkong
 * @Date: 2020/6/2 21:55
 * @Version 1.0
 */
public class ThreadSafety03 extends Thread {

    private static int count = 0;

    @Override
    public void run() {
        while (true) {
            if (count > 100) {
                break;
            }
            int count = getCount();
            System.out.println(Thread.currentThread().getName() + ": " + count);
        }
    }

    public int getCount() {
        synchronized (this.getClass()) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            return count++;
        }


    }

    public static void main(String[] args) {

        ThreadSafety03 t1 = new ThreadSafety03();
        ThreadSafety03 t2 = new ThreadSafety03();
        t1.start();
        t2.start();

    }

}
