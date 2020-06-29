package com.cmpay.zz.dto;

import lombok.Data;

import java.util.List;

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
    private Long createBy;
    private Byte isUse;
    private List<Long> rolesIds;
}
