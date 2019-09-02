package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

//市级表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class City {
    private Integer id;       //城市编号

    private Integer pid;          //省编号

    private String cname;       //城市名称
}
