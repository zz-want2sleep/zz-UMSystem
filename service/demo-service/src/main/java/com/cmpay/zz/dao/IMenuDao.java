/*
 * @ClassName IMenuDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-29 13:22:36
 */
package com.cmpay.zz.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.zz.entity.MenuDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IMenuDao extends BaseDao<MenuDO, Long> {
}