/*
 * @ClassName IPower_menuDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-29 22:59:07
 */
package com.cmpay.zz.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.zz.entity.Power_menuDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface IPower_menuDao extends BaseDao<Power_menuDO, Long> {
}