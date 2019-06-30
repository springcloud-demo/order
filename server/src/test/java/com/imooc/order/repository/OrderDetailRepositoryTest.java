package com.imooc.order.repository;

import com.imooc.order.OrderApplicationTests;
import com.imooc.order.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests {
    @Autowired
    private  OrderDetailRepository orderDetailRepository;
    @Test
    public void testSave(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123131");
        orderDetail.setOrderId("11213");
        orderDetail.setProductIcon("http://xxx.com");
        orderDetail.setProductId("157875196366160022");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(0.01));
        orderDetail.setProductQuantity(2);
        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertTrue(result!=null);

    }

}