package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

//美豆明细表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class ScoreDetail {
    private Integer id;             //美豆明细编号
    private Integer scoreId;             //积分记录编号
    private Integer userId;                //用户编号
    private Integer scoreTypeId;              //美豆类型编号
    private Date getTime;                  //获得的时间
}
