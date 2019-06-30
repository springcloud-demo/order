package com.imooc.order.Controller;

import com.imooc.order.dto.OrderDTO;
import com.imooc.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @ClassName: SendMessageController
 * @Description: TODO
 * @Author: ZhangChen
 * @Date: 2019/6/20 12:36
 **/
@RestController
public class SendMessageController {
    @Autowired
    private StreamClient streamClient;

    /*@GetMapping("/sendMessage")
    public void process(){
        String message = "now "+new Date();
        streamClient.output().send(MessageBuilder.withPayload(message).build());
    }*/
    /**
     * @Author ZhangChen
     * @Description //TODO 发送方的DTO对象
     * @Date 17:28 2019/6/20
     * @Param []
     * @return void
     **/
    @GetMapping("/sendMessage")
    public void process(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123456");
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }
}
