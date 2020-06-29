package com.cmpay.zz.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleInfoQueryRspDTO extends PageableRspDTO {


        private List<RoleInfoDTO> list;

}
