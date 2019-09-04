package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

//商品分类表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class Category {
    private Integer cid;    //分类编号

    private String  name;       //分类名称

    private Integer  parentId;     //分类父编号

    private Integer cLevel;     //分类级层

}
