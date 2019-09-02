package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

//评价表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class Evaluate {
    private Integer id;                 //评价编号
    private Integer goodsId;           //商品编号
    private Integer userId;              //用户编号
    private String  content;           //评价内容
    private Integer star;             //星级
    private String  imgs;             //图片
    private Date time;             //评价时间
}
