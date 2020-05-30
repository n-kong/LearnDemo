package com.nkong.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: nkong
 * @Date: 2020/5/30 17:06
 * @Version 1.0
 */
public class Start {

    private static final Logger LOGGER = LoggerFactory.getLogger(String.class);

    public static void main(String[] args) {
        FutureClient client = new FutureClient();
        Data request = client.submit("hhh");
        LOGGER.info("数据发送成功.");
        LOGGER.info("主线程执行其他任务...");
        String result = request.getRequest();
        LOGGER.info("主线程获取返回结果：{}", result);
    }

}
