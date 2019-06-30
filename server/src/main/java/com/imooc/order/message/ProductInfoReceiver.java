package com.imooc.order.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.imooc.order.utils.JsonUtil;
import com.imooc.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: ProductInfoReceiver
 * @Description: TODO
 * @Author: ZhangChen
 * @Date: 2019/6/20 18:01
 **/
@Slf4j
@Component
public class ProductInfoReceiver {

    private static final String PRODUCT_STOCK_TEMPLATE="product_stock_%s";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message){
        log.info(message);
        List<ProductInfoOutput> productInfoOutputList = (List<ProductInfoOutput>)JsonUtil.fromJson(message,
                new TypeReference<List<ProductInfoOutput>>(){} );
        //存储到redis中还是存单个,这里要遍历一下
        productInfoOutputList.forEach(e->{
            stringRedisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE,e.getProductId()),
                    String.valueOf(e.getProductStock()));
        });

    }
}
