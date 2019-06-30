package com.imooc.order.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.imooc.order.dataobject.OrderDetail;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.exception.OrderException;
import com.imooc.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class OrderForm2OrderDTO {
    public static OrderDTO convert(OrderForm orderForm){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetailList = new ArrayList<>();
        Gson gson = new Gson();
        try {
           orderDetailList =  gson.fromJson(orderForm.getItems(),new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (Exception e){
            log.error("json转换错误,String = {}",orderForm.getItems());
            throw new OrderException(-1,"gson转换出错");
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
