package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

//优惠券领取记录表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class CouponReceive {
    private Integer  id;                   //券领取编号

    private Integer couponId;               //优惠券表编号

    private Integer userId;                //用户编号

    private Date time;                  //领取时间

    private Integer status;                   //状态
}
