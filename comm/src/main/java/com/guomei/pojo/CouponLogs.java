package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

//优惠卷消费记录
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class CouponLogs {

    private Integer   id;                //券消费编号

    private Integer userId;               //用户编号

    private Integer couponId;               //优惠券表编号

    private Integer orderId;               //订单编号
}
