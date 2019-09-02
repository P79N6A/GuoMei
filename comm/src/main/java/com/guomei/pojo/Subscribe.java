package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

//商品订阅表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class Subscribe {
    private Integer id;                  //商品订阅编号
    private Integer goodsId;                 //商品编号
    private double lowMoney;           //低于价格
    private String  email;             //电子邮箱
}
