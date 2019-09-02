package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

//订单明细表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class OrderDetail {
    private Integer  id;            //订单明细表编号
    private Integer orderId;             //订单编号
    private Integer goodsId;             //商品编号
    private double  money;              //价格
    private Integer  num;              //数量
}
