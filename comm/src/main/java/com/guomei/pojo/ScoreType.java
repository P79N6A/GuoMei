package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

//美豆类型表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class ScoreType {
    private Integer id;     //美豆类型编号
    private String typeName;               //类型名称
    private Integer  value;          //  对应增减值
}
