package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

//秒杀成功明细表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class SeckillDes {
    private Integer id;     //秒杀成功明细编号
    private Integer userId;               //用户编号
    private Integer goodsId;                //商品编号
    private Date time;             //创建时间(秒杀成功的时间)
}
