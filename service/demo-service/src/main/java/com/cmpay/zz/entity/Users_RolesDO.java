/*
 * @ClassName Users_RolesDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-29 22:59:07
 */
package com.cmpay.zz.entity;

import com.cmpay.lemon.framework.annotation.DataObject;

@DataObject
public class Users_RolesDO extends BaseDO {
    /**
     * @Fields urId 用户角色关联id
     */
    private Long urId;
    /**
     * @Fields userid 用户id
     */
    private Long userid;
    /**
     * @Fields roleid 角色id
     */
    private Long roleid;

    public Long getUrId() {
        return urId;
    }

    public void setUrId(Long urId) {
        this.urId = urId;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }
}