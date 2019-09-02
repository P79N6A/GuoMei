package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

//收货地址表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class Address {
    private Integer id;     //收货地址编号

    private Integer provinceId;   //省编号

    private Integer cityId;      //市编号

    private Integer districtId;   //区编号

    private Integer streetId;   //街道编号

    private Integer userId;     //用户编号

    private String  userName;   //收货人姓名

    private String address;    //详细地址

    private String  phone;   //手机号码

    private String  email;   //邮箱

    private Integer isdefault;    //是否默认


}
