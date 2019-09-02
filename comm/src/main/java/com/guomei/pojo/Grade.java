package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

//会员等级表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class Grade {
    private Integer id;               //等级编号
    private String gradeName;           //等级名称
    private Integer low;                 //最低成长值
    private Integer high;            //最高成长值
}
