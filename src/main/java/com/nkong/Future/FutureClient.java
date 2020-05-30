package com.nkong.Future;

/**
 * @Author: nkong
 * @Date: 2020/5/30 17:01
 * @Version 1.0
 */
public class FutureClient {
    public Data submit(String requestData) {
        FutureData futureData = new FutureData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ReadData readData = new ReadData(requestData);
                futureData.setReadData(readData);
            }
        }).start();

        return futureData;
    }

}
