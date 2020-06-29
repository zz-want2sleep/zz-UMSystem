package com.cmpay.zz.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleInfoQueryReqDTO extends PageableRspDTO {

    private String roleName;

}
