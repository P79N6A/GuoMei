package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

//秒杀商品表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class Seckill {

    private Integer id;            //秒杀商品编号
    private Integer goodsId;      //商品编号
    private Integer number;     //库存数量
    private Date startTime;          //秒杀开始时间
    private Date endTime;                 //秒杀结束时间
    private Date time;              //创建时间
}
