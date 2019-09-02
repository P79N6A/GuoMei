package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

//收藏店铺表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class CollectionShop {
    private Integer id;                    //店铺编号


    private Integer shopId;              //收藏店铺编号


    private Date time;         //收藏时间

    private Integer userId;             //用户编号
}
