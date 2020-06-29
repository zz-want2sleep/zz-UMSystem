/*
 * @ClassName IUsers_RolesDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-29 22:59:07
 */
package com.cmpay.zz.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.zz.entity.Users_RolesDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface IUsers_RolesDao extends BaseDao<Users_RolesDO, Long> {
}