package com.cmpay.zz.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
* @program: UserInfoBO
* @description:用户信息展示
* @author: zhangzhe
* @create: 2020/6/23 0023
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoBO {
    /**
     * @Fields id 用户id
     */
    private Long id;
    /**
     * @Fields tName 用户名称
     */
    private String loginName;
    /**
     * @Fields password 用户密码
     */
    private String password;
    /**
     * @Fields email 用户邮箱
     */
    private String email;
    /**
     * @Fields phonenumber 用户电话
     */
    private Long phonenumber;
    /**
     * @Fields createBy 创建人
     */
    private String createBy;
    /**
     * @Fields createDate 创建时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;
    /**
     * @Fields updateBy 更新人
     */
    private String updateBy;
    /**
     * @Fields updateDate 更新时间
     */

    private LocalDateTime updateDate;
    /**
     * @Fields isUse 是否可用
     */
    private Byte isUse;
}
