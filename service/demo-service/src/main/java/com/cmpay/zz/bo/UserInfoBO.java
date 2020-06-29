package com.cmpay.zz.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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
    private Long userId;
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
     * @Fields createBy 创建角色
     */
    private Long  createBy;
    /**
     * @Fields createDate 创建时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;
    /**
     * @Fields updateBy 更新角色
     */
    private Long updateBy;
    /**
     * @Fields updateDate 更新时间
     */

    private LocalDateTime updateDate;
    /**
     * @Fields isUse 是否可用
     */
    private Byte isUse;
    /**
     * 角色集合
     */
    private List<Long> roleIds;
}
