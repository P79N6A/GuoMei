package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

//美豆记录表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class Score {
    private Integer id;               //积分记录编号
    private Integer userId;            //用户编号
    private Integer scores;             //总积分
}
