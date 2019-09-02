package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

//礼包表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class Gift {
    private Integer id;       //礼包编号
    private String giftName;           //礼包名称
    private Date time;            //领取时间
    private Date endTime;             //过期时间
}
