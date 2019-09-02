package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

//成长值表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class Growup {
    private Integer id;      //成长值编号
    private Integer userId;                   //用户编号
    private Integer growupSum;                   //总成长值
}
