package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

//区级表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class District {
    private Integer id;    //区编号

    private Integer cid;      //城市编号

    private String dname;      //区名称
}
