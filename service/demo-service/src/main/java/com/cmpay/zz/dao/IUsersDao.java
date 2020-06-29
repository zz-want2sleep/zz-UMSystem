/*
 * @ClassName IUsersDao
 * @Description
 * @version 1.0
 * @Date 2020-06-29 22:24:19
 */
package com.cmpay.zz.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.zz.entity.UsersDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;
@Repository
@Mapper
public interface IUsersDao extends BaseDao<UsersDO, Long> {
    /**
     *description: 登录
     * @author: zhangzhe
     * @param
     * @return: com.cmpay.zz.entity.UsersDO
     * @Date: 2020/6/29 0029
     */
    public UsersDO Login(String loginName,String password);
    /**
     *description: 根据用户姓名查询
     * @author: zhangzhe
     * @param loginName
     * @return: com.cmpay.zz.entity.UsersDO
     * @Date: 2020/6/29 0029
     */
    public UsersDO getUserByName(String loginName);
    /**
     *description: 更新密码
     * @author: zhangzhe
     * @param map
     * @return: int
     * @Date: 2020/6/29 0029
     */
    public int updatePassword(Map map);
}