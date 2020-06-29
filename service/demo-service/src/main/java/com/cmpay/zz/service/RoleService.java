package com.cmpay.zz.service;

import com.cmpay.lemon.framework.page.PageInfo;
import com.cmpay.zz.bo.RoleInfoBO;
import com.cmpay.zz.bo.RoleInfoQueryBO;
import com.cmpay.zz.entity.RolesDO;

import org.springframework.stereotype.Service;


@Service
public interface RoleService {
    /**
    *description: 查询角色
    * @author: zhangzhe
     * @param roleInfoBO
    * @return: com.cmpay.zz.entity.RolesDO
    * @Date: 2020/6/29 0029
    */
    public RolesDO getRoleById(RoleInfoBO roleInfoBO);
    
   /**
   *description: 分页查询
   * @author: zhangzhe
    * @param roleInfoQueryBO
   * @return: com.cmpay.lemon.framework.page.PageInfo<com.cmpay.zz.entity.RolesDO>
   * @Date: 2020/6/29 0029
   */ 
    public PageInfo<RolesDO> findRoles(RoleInfoQueryBO roleInfoQueryBO);
}
