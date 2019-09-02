package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

//优惠券基础配置表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class Coupon {
    private Integer  id;                       //优惠券表编号


    private Integer categoryId;               //分类编号

    private Integer  type;                 //所属类型

    private String couponName;                //优惠券名称

    private Date startTime;            //开始时间

    private Date endTime;               //结束时间

    private double couponMoney;               //优惠金额

    private Integer  status;                   //状态

    private String  remarks;                 //优惠券的说明

    private double fullMoney;                //金额满多少


    private Integer couponCount;               //发放数量

    private Integer couponScope;                  //使用范围

    private Integer couponLimit;                //每人限领
}
