package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

//成长值明细表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class GrowupDetail {
    private Integer id;              //明细编号
    private Integer typeId;              //成长值类型编号
    private Integer growupId;               //成长值编号
    private Integer userId;               //用户编号
    private Date time;              //获得日期
}
