package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

//省级表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class Province {
    private Integer id;     //省编号
    private String name;   //省名称
}
