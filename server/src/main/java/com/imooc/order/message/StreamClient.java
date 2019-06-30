package com.imooc.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @ClassName: StreamClient
 * @Description: TODO
 * @Author: ZhangChen
 * @Date: 2019/6/20 12:30
 **/
public interface StreamClient {
    String INPUT = "myMessageIn";
    String OUTPUT = "myMessageOut";

    String INPUT2 = "myMessageIn2";
    String OUTPUT2 = "myMessageOut2";
    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();

    @Input(StreamClient.INPUT2)
    SubscribableChannel input2();

    @Output(StreamClient.OUTPUT2)
    MessageChannel output2();
}
