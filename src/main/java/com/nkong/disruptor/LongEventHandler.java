package com.nkong.disruptor;

import com.lmax.disruptor.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: nkong
 * @Date: 2020/6/4 21:45
 * @Version 1.0
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    private static Logger LOGGER = LoggerFactory.getLogger(LongEventHandler.class);
    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        LOGGER.info("消费者获取数据: {}", longEvent.getValue());
    }
}
