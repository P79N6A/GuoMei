package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

//会员商品表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class VipGoods {
    private Integer id;        //会员商品编号
    private Integer gradeId;         //会员等级编号
    private double vipPrice;          //优惠价格
    private Date vipTime;                   //上线时间
    private Integer goodsId;               //商品编号
}
