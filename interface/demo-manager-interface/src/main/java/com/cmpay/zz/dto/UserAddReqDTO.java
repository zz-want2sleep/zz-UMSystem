package com.cmpay.zz.dto;

import lombok.Data;

/**
* @program: UserAddReqDTO
* @description: 增添用户
* @author: zhangzhe
* @create: 2020/6/28 0028
*/
@Data
public class UserAddReqDTO {
    private String loginName;
    private String password;
    private String email;
    private Long phonenumber;
    private String createBy;
    private Byte isUse;
}
