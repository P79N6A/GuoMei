package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

//店铺表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class Shop {
    private Integer id;              //店铺编号
    private String shopName;            //店铺名称
    private String shopImg;                 //店铺主图
}
