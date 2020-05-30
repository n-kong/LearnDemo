package com.nkong.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: nkong
 * @Date: 2020/5/30 16:50
 * @Version 1.0
 */
public class ReadData extends Data{

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadData.class);
    private String result;

    public ReadData(String requestData) {
        LOGGER.info("发送网络请求, requestData is {}，开始...", requestData);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.getMessage();
        }
        LOGGER.info("请求执行完毕，获取返回结果！");
        this.result = "今天星期六";
    }

    @Override
    public String getRequest() {
        return result;
    }
}
