package com.cmpay.zz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleInfoDTO {
        /**
         * 角色id
         */
        private Long id;
        /**
         * 角色姓名
         */
        private String roleName;
        /**
         * 角色备注
         */
        private String note;
        /**
         * 创建人
         */
        private String createBy;
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
         * 修改人
         */
        private String updateBy;
        /**
         * 修改时间
         */
        private LocalDateTime updateDate;
    }
