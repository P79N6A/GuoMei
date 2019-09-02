package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

//购物车表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class Cart {
    private Integer  id;              //购物车编号

    private Integer userId;               //用户编号

    private Integer goodsId;                //商品编号

    private Integer   num;                //购买数量

    private double price;                  //价格

    private double  total;               //总金额(小计)

}
