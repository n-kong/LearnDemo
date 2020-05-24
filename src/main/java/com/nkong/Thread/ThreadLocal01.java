package com.nkong.Thread;

/**
 * @Author: nkong
 * @Date: 2020/5/24 15:12
 * @Version 1.0
 */
public class ThreadLocal01 extends Thread {
    private Res res;

    public ThreadLocal01(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + res.getNumber());
        }

    }

    public static void main(String[] args) {
        Res res = new Res();
        ThreadLocal01 threadLocal01 = new ThreadLocal01(res);
        Thread t1 = new Thread(threadLocal01);
        Thread t2 = new Thread(threadLocal01);
        t1.start();
        t2.start();
    }

}

class Res {
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        protected Integer initialValue() {
            return 0;
        }
    };

    public Integer getNumber() {
        int count = threadLocal.get() + 1;
        threadLocal.set(count);
        return count;
    }
}
