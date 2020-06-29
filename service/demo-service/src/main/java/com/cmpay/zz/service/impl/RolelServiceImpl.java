package com.cmpay.zz.service.impl;

import com.cmpay.lemon.common.exception.BusinessException;
import com.cmpay.lemon.common.utils.BeanUtils;
import com.cmpay.lemon.framework.page.PageInfo;
import com.cmpay.lemon.framework.utils.PageUtils;
import com.cmpay.zz.bo.RoleInfoBO;
import com.cmpay.zz.bo.RoleInfoQueryBO;
import com.cmpay.zz.dao.IRolesDao;
import com.cmpay.zz.entity.RolesDO;
import com.cmpay.zz.enums.MsgEnum;
import com.cmpay.zz.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleInfo;
@Service
public class RolelServiceImpl implements RoleService {
    @Autowired
    private IRolesDao rolesDao;
    @Override
    public RolesDO getRoleById(RoleInfoBO roleInfoBO) {
        RolesDO rolesDO = rolesDao.get(roleInfoBO.getRoleId());
        System.out.println(rolesDO);
        if(rolesDO==null){
            BusinessException.throwBusinessException(MsgEnum.USER_NOT_EXISTS);
        }
        return rolesDO;
    }

    @Override
    public PageInfo<RolesDO> findRoles(RoleInfoQueryBO roleInfoQueryBO) {

        RolesDO rolesDO = new RolesDO();
        BeanUtils.copyProperties(rolesDO,roleInfoQueryBO);
        return PageUtils.pageQueryWithCount(roleInfoQueryBO.getPageNum(),roleInfoQueryBO.getPageSize(),()->rolesDao.find(rolesDO));
    }
}
