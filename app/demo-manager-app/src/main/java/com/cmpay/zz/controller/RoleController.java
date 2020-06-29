package com.cmpay.zz.controller;

import com.cmpay.lemon.common.exception.BusinessException;
import com.cmpay.lemon.framework.data.DefaultRspDTO;
import com.cmpay.lemon.framework.data.NoBody;
import com.cmpay.zz.bo.RoleInfoBO;
import com.cmpay.zz.dto.RoleInfoDTO;
import com.cmpay.zz.entity.RolesDO;
import com.cmpay.zz.enums.MsgEnum;
import com.cmpay.zz.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;
    @PostMapping("user/role")
    public DefaultRspDTO<RoleInfoDTO> getRoleById(@RequestBody RoleInfoDTO roleInfoDTO){
        RoleInfoBO roleInfoBO = new RoleInfoBO();
        roleInfoBO.setId(roleInfoDTO.getId());
        BeanUtils.copyProperties(roleInfoDTO,roleInfoBO);
        RolesDO rolesDO = roleService.getRoleById(roleInfoBO);
        if(rolesDO==null){
            BusinessException.throwBusinessException(MsgEnum.ROLE_NOT_EXISTS);
        }
        BeanUtils.copyProperties(roleInfoBO,roleInfoDTO);
        return DefaultRspDTO.newSuccessInstance(roleInfoDTO);
    }
}
