package com.cmpay.zz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
* @program: UserUpdateReqDTO
* @description:修改用户
* @author: zhangzhe
* @create: 2020/6/28 0028
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateReqDTO {
    private Long id;
    private String loginName;
    private String password;
    private String email;
    private String updateBy;
    private LocalDateTime updateDate;
    private Long phonenumber;
    private Byte isUse;
}
