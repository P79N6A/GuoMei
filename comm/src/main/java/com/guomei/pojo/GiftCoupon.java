package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

//礼包券
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class GiftCoupon {
    private Integer id;      //礼包券编号
    private Integer giftId;        //礼包编号
    private Integer couponId;        //优惠券表编号
}
