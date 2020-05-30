package com.nkong.Future;

/**
 * @Author: nkong
 * @Date: 2020/5/30 16:46
 * @Version 1.0
 */
public class FutureData extends Data {

    private boolean FLAG = false;
    private ReadData readData;

    public synchronized void setReadData(ReadData readData) {
        if (FLAG) {
            return;
        }
        this.readData = readData;
        FLAG = true;
        notify();
    }

    @Override
    public synchronized String getRequest() {
        while (!FLAG) {
            try {
                wait();
            } catch (Exception e) {

            }
        }
        return readData.getRequest();
    }
}
