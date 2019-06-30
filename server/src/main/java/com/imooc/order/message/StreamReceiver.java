package com.imooc.order.message;

import com.imooc.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @ClassName: StreamReceiver
 * @Description: TODO
 * @Author: ZhangChen
 * @Date: 2019/6/20 12:31
 **/

@Slf4j
@Component
@EnableBinding(StreamClient.class)
public class StreamReceiver {
   /* @StreamListener(StreamClient.OUTPUT)
    public void process(Object message){
        log.info("StreamReceiver:{}",message);
    }*/
    /**
     * @Author ZhangChen
     * @Description //TODO 接收方的DTO对象消息
     * @Date 13:07 2019/6/20
     * @Param [message]
     * @return void
     **/
    @StreamListener(StreamClient.OUTPUT)
    @SendTo(StreamClient.INPUT2)
    public String process(OrderDTO message){
        log.info("StreamReceiver:{}",message);
        return "已经收到";
    }

    @StreamListener(StreamClient.INPUT2)
    public void process2(String message){
        log.info("StreamReceiver:{}",message);
    }
}
