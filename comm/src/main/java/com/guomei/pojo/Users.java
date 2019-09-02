package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

//用户表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class Users {
    private Integer id;           //用户编号
    private String userName;      //用户名
    private String passWord;    //用户密码
    private Integer sex;          //性别
    private Date  birthday;          //生日
    private String phone;           //手机号码
    private String  email;             //邮箱
    private String   address;     //家庭住址
    private String  headImg;      //头像图片
    private Date time;                //注册时间
    private Integer role;            //角色


}
