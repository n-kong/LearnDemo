package com.nkong.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @Author: nkong
 * @Date: 2020/6/4 21:42
 * @Version 1.0
 */

// 实例化LongEvent对象
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }


}
