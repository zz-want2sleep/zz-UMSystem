package com.cmpay.zz.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
* @program: UserInfoQueryBO
* @description: 分页查询业务实体
* @author: zhangzhe
* @create: 2020/6/23 0023
*/
@Data
public class UserInfoQueryBO {
    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 每页记录数
     */
    private Integer pageSize;
    /**
     * 用户id
     */
    private Long id;
    /**
     * 用户姓名
     */
    private String loginName;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 电话
     */
    private Long phonenumber;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 创建角色
     */
    private Long createBy;
    /**
     * 是否可用
     */
    private Byte isUse;
    /**
     * 创建时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;
    /**
     * 修改角色
     */
    private Long updateBy;
    /**
     * 修改时间
     */
    private LocalDateTime updateDate;
}
