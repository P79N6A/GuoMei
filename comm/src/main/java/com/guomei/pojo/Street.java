package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

//街道表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class Street {
    private Integer id;      //街道编号
    private Integer did;      //区级编号
    private String sname;       //街道名称
}
