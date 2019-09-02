package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

//商品表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class Goods {
    private Integer id;       //商品编号
    private Integer shopId;             //店铺编号
    private Integer bid;            //品牌编号
    private String title;         //商品名称
    private String  subTitle;          //副标题
    private String  mainImg;          //商品主图
    private String  desImg;          //详情图片
    private String describe;            //商品描述
    private BigDecimal price;          //商品价格
    private Integer stock;              //库存
    private Integer  state;          //状态
    private Integer  seckill;             //销量
}
