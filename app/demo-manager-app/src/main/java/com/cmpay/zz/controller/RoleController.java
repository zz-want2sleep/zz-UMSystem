package com.cmpay.zz.controller;

import com.cmpay.framework.data.response.GenericRspDTO;
import com.cmpay.lemon.common.exception.BusinessException;
import com.cmpay.lemon.framework.annotation.QueryBody;
import com.cmpay.lemon.framework.data.DefaultRspDTO;
import com.cmpay.lemon.framework.data.NoBody;
import com.cmpay.lemon.framework.page.PageInfo;
import com.cmpay.zz.bo.RoleInfoBO;
import com.cmpay.zz.bo.RoleInfoQueryBO;
import com.cmpay.zz.dto.RoleInfoDTO;
import com.cmpay.zz.dto.RoleInfoQueryReqDTO;
import com.cmpay.zz.dto.RoleInfoQueryRspDTO;
import com.cmpay.zz.entity.RolesDO;
import com.cmpay.zz.entity.UsersDO;
import com.cmpay.zz.enums.MsgEnum;
import com.cmpay.zz.service.RoleService;
import com.cmpay.zz.utils.BeanConvertUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("user/role")
    public DefaultRspDTO<RoleInfoDTO> getRoleById(@RequestBody RoleInfoDTO roleInfoDTO) {
        RoleInfoBO roleInfoBO = new RoleInfoBO();
        roleInfoBO.setRoleId(roleInfoDTO.getRoleId());
        BeanUtils.copyProperties(roleInfoDTO, roleInfoBO);
        RolesDO rolesDO = roleService.getRoleById(roleInfoBO);
        if (rolesDO == null) {
            BusinessException.throwBusinessException(MsgEnum.ROLE_NOT_EXISTS);
        }
        BeanUtils.copyProperties(rolesDO, roleInfoDTO);
        return DefaultRspDTO.newSuccessInstance(roleInfoDTO);
    }

    @GetMapping("/v1/demo/role/select")
    public GenericRspDTO<RoleInfoQueryRspDTO> getUserInfoPage(@QueryBody RoleInfoQueryReqDTO roleInfoQueryReqDTO) {
        RoleInfoQueryBO userInfoQueryBO = new RoleInfoQueryBO();
        BeanUtils.copyProperties(roleInfoQueryReqDTO, userInfoQueryBO);
        PageInfo<RolesDO> page = roleService.findRoles(userInfoQueryBO);

        List<RoleInfoDTO> roleInfos = BeanConvertUtils.convertList(page.getList(), RoleInfoDTO.class);
        RoleInfoQueryRspDTO roleInfoQueryRspDTO = new RoleInfoQueryRspDTO();
        roleInfoQueryRspDTO.setList(roleInfos);
        roleInfoQueryRspDTO.setPageNum(page.getPageNum());
        roleInfoQueryRspDTO.setPageSize(page.getPageSize());
        roleInfoQueryRspDTO.setPages(page.getPages());
        roleInfoQueryRspDTO.setTotal(page.getTotal());
        roleInfoQueryRspDTO.setMsgCd(MsgEnum.SUCCESS.getMsgCd());
        roleInfoQueryRspDTO.setMsgInfo(MsgEnum.SUCCESS.getMsgInfo());
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS, roleInfoQueryRspDTO);
    }
}
