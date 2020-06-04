package com.nkong.disruptor;

import com.lmax.disruptor.RingBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;

/**
 * @Author: nkong
 * @Date: 2020/6/4 22:15
 * @Version 1.0
 */
public class LongEventProducer {

    private static Logger LOGGER = LoggerFactory.getLogger(LongEventProducer.class);
    private RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer byteBuffer) {
        // 获取事件队列下标位置
        long seq = ringBuffer.next();
        try {
            // 取出空队列
            LongEvent longEvent = ringBuffer.get(seq);
            // 给空队列赋值
            longEvent.setValue(byteBuffer.getLong(0));
        } catch (Exception e) {
            LOGGER.error("error message {}", e.getMessage(), e);
        } finally {
            LOGGER.info("生产者发送数据...");
            ringBuffer.publish(seq);
        }

    }
}
