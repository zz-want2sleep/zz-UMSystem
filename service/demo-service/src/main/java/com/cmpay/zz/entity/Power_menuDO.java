/*
 * @ClassName Power_menuDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-29 22:59:07
 */
package com.cmpay.zz.entity;

import com.cmpay.lemon.framework.annotation.DataObject;

@DataObject
public class Power_menuDO extends BaseDO {
    /**
     * @Fields pmId 权限菜单关联id
     */
    private Long pmId;
    /**
     * @Fields powerid 权限id
     */
    private Long powerid;
    /**
     * @Fields menuid 菜单id
     */
    private Long menuid;

    public Long getPmId() {
        return pmId;
    }

    public void setPmId(Long pmId) {
        this.pmId = pmId;
    }

    public Long getPowerid() {
        return powerid;
    }

    public void setPowerid(Long powerid) {
        this.powerid = powerid;
    }

    public Long getMenuid() {
        return menuid;
    }

    public void setMenuid(Long menuid) {
        this.menuid = menuid;
    }
}