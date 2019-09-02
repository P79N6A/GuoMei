package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

//品牌表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class Brand {
    private Integer id;           //品牌编号

    private Integer cid;             //商品分类编号

    private String bname;          //品牌名称


}
