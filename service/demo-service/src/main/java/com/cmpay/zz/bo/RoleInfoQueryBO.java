package com.cmpay.zz.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleInfoQueryBO {
    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 每页记录数
     */
    private Integer pageSize;
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 角色姓名
     */
    private String roleName;
    /**
     * 角色备注
     */
    private String note;
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
     * 更新角色
     */
    private Long updateBy;
    /**
     * 修改时间
     */
    private LocalDateTime updateDate;
}
