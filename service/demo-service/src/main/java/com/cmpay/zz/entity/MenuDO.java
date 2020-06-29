/*
 * @ClassName MenuDO
 * @Description 
 * @version 1.0
 * @Date 2020-06-29 22:59:07
 */
package com.cmpay.zz.entity;

import com.cmpay.lemon.framework.annotation.DataObject;
import java.time.LocalDateTime;

@DataObject
public class MenuDO extends BaseDO {
    /**
     * @Fields menuId 菜单id
     */
    private Long menuId;
    /**
     * @Fields name 菜单名称
     */
    private String name;
    /**
     * @Fields url 菜单URL
     */
    private String url;
    /**
     * @Fields supid 父级菜单id
     */
    private Long supid;
    /**
     * @Fields createBy 创建角色
     */
    private Long createBy;
    /**
     * @Fields createDate 创建时间
     */
    private LocalDateTime createDate;
    /**
     * @Fields updateBy 更新角色
     */
    private Long updateBy;
    /**
     * @Fields updateDate 更新时间
     */
    private LocalDateTime updateDate;
    /**
     * @Fields isUse 是否可用
     */
    private Byte isUse;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getSupid() {
        return supid;
    }

    public void setSupid(Long supid) {
        this.supid = supid;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Byte getIsUse() {
        return isUse;
    }

    public void setIsUse(Byte isUse) {
        this.isUse = isUse;
    }
}