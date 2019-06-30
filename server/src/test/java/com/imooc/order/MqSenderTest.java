package com.imooc.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @ClassName: MqSenderTest
 * @Description: 发送mq消息测试
 * @Author: ZhangChen
 * @Date: 2019/6/16 12:20
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MqSenderTest extends OrderApplicationTests {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send(){
        amqpTemplate.convertAndSend("computerOrder","now"+new Date());
    }

    @Test
    public void sendOrder(){
        amqpTemplate.convertAndSend("myOrder","computer","now "+new Date());
    }
    @Test
    public void sendOrder2(){
        amqpTemplate.convertAndSend("myOrder","now 2"+new Date());
    }
}
