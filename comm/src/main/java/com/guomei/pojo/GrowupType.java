package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

//成长值类型表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class GrowupType {
    private Integer id;                  //类型编号
    private String name;              //类型名称
    private Integer  value;            //所获成长值
}
