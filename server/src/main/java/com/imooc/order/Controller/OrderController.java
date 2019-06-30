package com.imooc.order.Controller;

import com.imooc.order.VO.ResultVO;
import com.imooc.order.VO.ResultVOUtil;
import com.imooc.order.converter.OrderForm2OrderDTO;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.exception.OrderException;
import com.imooc.order.form.OrderForm;
import com.imooc.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    /*
    1.参数校验
    2.查询商品信息(调用商品服务)
    3.计算出总价
    4.扣库存(调用商品服务)
    5.订单入库
    */
    @Autowired
    private OrderService orderService;
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        log.info("进入了");
        if(bindingResult.hasErrors()){
            log.error("创建订单参数不正确 ={}",orderForm);
            throw new OrderException(1,bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);
        new Date();
        //判断购物车是否为空
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("创建订单信息失败,购物车为空");
            throw new OrderException(-1,"购物车为空");
        }
        OrderDTO result = orderService.create(orderDTO);
        Map<String,String> map = new HashMap<>();
        map.put("orderId",result.getOrderId());
        return ResultVOUtil.success(map);
    }

    @PostMapping("/finish")
    public ResultVO<OrderDTO> finish(@RequestParam("orderId") String orderId){
        return ResultVOUtil.success(orderService.finish(orderId));
    }
}
