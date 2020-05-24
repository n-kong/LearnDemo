package com.nkong.Thread;

/**
 * @Author: nkong
 * @Date: 2020/5/24 16:19
 * @Version 1.0
 */
public class ThreadVolatile {

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo03 threadDemo03 = new ThreadDemo03();
        threadDemo03.start();
        Thread.sleep(3000);
        threadDemo03.setRunning(false);
        System.out.println("flag已经改为false");
        Thread.sleep(1000);
        System.out.println("flag is: " + threadDemo03.flag);
    }

}

class ThreadDemo03 extends Thread {

    public volatile boolean flag = true;
    @Override
    public void run() {
        System.out.println("线程开始...");
        while (flag) {

        }
        System.out.println("线程结束...");
    }

    public void setRunning(boolean flag) {
        this.flag = flag;
    }
}