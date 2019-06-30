package com.imooc.order.repository;

import com.imooc.order.OrderApplicationTests;
import com.imooc.order.dataobject.OrderMaster;
import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests {
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Test
    public void testSave(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234566");
        orderMaster.setBuyerName("张晨");
        orderMaster.setBuyerPhone("18216072198");
        orderMaster.setBuyerAddress("河北石家庄");
        orderMaster.setBuyerOpenid("1110110");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(result!=null);
    }

}