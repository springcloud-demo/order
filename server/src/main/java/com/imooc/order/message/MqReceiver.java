package com.imooc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MqReceiver
 * @Description: TODO
 * @Author: ZhangChen
 * @Date: 2019/6/16 12:12
 **/
//idea 多模块 修改了代码不能自己编译
@Slf4j
@Component
public class MqReceiver {
//    @RabbitListener(queues = "myQueue")
// 2.自动创建队列
//    @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    //3.自动创建 exchange和Queue绑定
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "fruit",
            value=@Queue("fruitOrder")
    ))
    public void process(String message){
        log.info("fruit MqReceiver:{}",message);
    }

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "computer",
            value=@Queue("computerOrder")
    ))
    public void processComputer(String message){
        log.info("computer MqReceiver :{}",message);
    }

}
