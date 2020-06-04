package com.nkong.disruptor;

/**
 * @Author: nkong
 * @Date: 2020/6/4 21:38
 * @Version 1.0
 */


// 表示生产者与消费者传递的数据类型
public class LongEvent {

    private Long value;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }


}
