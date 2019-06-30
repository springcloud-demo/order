package com.imooc.order.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    PARAM_ERROR(1,"登陆失败"),
    CART_ERROR(2,"角色权限有误"),
    ORDER_NOT_EXIST(3,"订单不存在"),
    ORDER_DETAIL_NOT_EXIST(5,"订单详情不存在"),
    ORDER_STATUS_ERROR(4,"订单状态为空"),
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
