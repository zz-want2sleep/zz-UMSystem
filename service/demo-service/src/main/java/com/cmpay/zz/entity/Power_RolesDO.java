/*
 * @ClassName Power_RolesDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-29 22:59:07
 */
package com.cmpay.zz.entity;

import com.cmpay.lemon.framework.annotation.DataObject;

@DataObject
public class Power_RolesDO extends BaseDO {
    /**
     * @Fields prId 权限角色关联id
     */
    private Long prId;
    /**
     * @Fields powerid 权限id
     */
    private Long powerid;
    /**
     * @Fields roleid 角色id
     */
    private Long roleid;

    public Long getPrId() {
        return prId;
    }

    public void setPrId(Long prId) {
        this.prId = prId;
    }

    public Long getPowerid() {
        return powerid;
    }

    public void setPowerid(Long powerid) {
        this.powerid = powerid;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }
}