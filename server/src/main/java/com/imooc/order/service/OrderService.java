package com.imooc.order.service;

import com.imooc.order.dto.OrderDTO;

public interface OrderService {
    /*创建订单*/
    OrderDTO create(OrderDTO orderDTO);
    /**
     * @Author ZhangChen
     * @Description //TODO 完结订单(只能卖家来操作)
     * @Date 17:21 2019/6/29
     * @Param [orderId]
     * @return com.imooc.order.dto.OrderDTO
     **/
    OrderDTO finish(String orderId);
}
