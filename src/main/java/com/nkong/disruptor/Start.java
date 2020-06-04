package com.nkong.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: nkong
 * @Date: 2020/6/4 21:51
 * @Version 1.0
 */
public class Start {

    public static void main(String[] args) {

        // 创建可以缓存的线程池， 提供发给consumer
        ExecutorService executor = Executors.newCachedThreadPool();
        // 创建Event工厂
        LongEventFactory longEventFactory = new LongEventFactory();
        // 定义ringBuffer大小
        int ringBuffer = 1024*1024;
        // 创建Disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<>(longEventFactory, ringBuffer, executor, ProducerType.MULTI, new YieldingWaitStrategy());
        // 注册消费者(可多个，复制发送)
        disruptor.handleEventsWith(new LongEventHandler());
        // 启动
        disruptor.start();
        // 创建RingBuffer容器
        RingBuffer<LongEvent> buffer = disruptor.getRingBuffer();
        // 创建生产者
        LongEventProducer producer = new LongEventProducer(buffer);
        // 指定缓冲区大小
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        for (int i = 0; i < 10; i++) {
            byteBuffer.putLong(0, i);
            producer.onData(byteBuffer);
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
        }
        executor.shutdown();
        disruptor.shutdown();
    }

}
