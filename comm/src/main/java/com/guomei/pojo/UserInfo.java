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
    private Integer id;
    private Integer uid;
    private Integer  gid;
    private Integer sid;
}
