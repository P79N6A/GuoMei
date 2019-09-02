package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

//礼包领取表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class GiftReceive {
    private Integer id;        //礼包领取表编号
    private Integer giftId;         //礼包编号
    private Integer userId;       //用户编号
}
