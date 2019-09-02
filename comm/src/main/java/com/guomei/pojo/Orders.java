package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

//订单表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class Orders {
    private Integer id;             //订单编号
    private Integer adressId;            //收货地址编号
    private Date payDate;              //支付时间
    private Date orderTime;                //订单创建时间
    private double  total;              //订单总价
    private Integer  status;              //订单状态
    private String orderNo;             //订单号
}
