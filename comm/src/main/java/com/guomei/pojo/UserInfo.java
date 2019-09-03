package com.guomei.pojo;

import lombok.*;
import lombok.experimental.Accessors;

//用户积分,会员值记录表
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@ToString
public class UserInfo {
    private Integer id; //编号
    private Integer uid; //用户编号
    private Integer  gid; //成长值表
    private Integer sid; //美豆积分值
}
