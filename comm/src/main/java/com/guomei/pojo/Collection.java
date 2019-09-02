package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

//收藏表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class Collection {
    private Integer id;     //收藏编号


    private Integer uid;            //用户编号

    private Integer goodsId;             //商品编号

    private Date ctime;             //收藏时间

}
