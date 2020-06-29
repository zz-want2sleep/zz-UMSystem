package com.cmpay.zz.service;


import com.cmpay.lemon.framework.page.PageInfo;
import com.cmpay.zz.bo.UserInfoBO;
import com.cmpay.zz.bo.UserInfoQueryBO;
import com.cmpay.zz.entity.UsersDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author: zhangzhe
* @Description: 操作用户
* @Date: 2020/6/22 0022
*/
@Service
public interface UserService {
/**
*description: 通过id查询用户
* @author: zhangzhe
 * @param id 用户id
* @return: com.cmpay.zz.entity.UsersDO
* @Date: 2020/6/22 0022
*/
    public UserInfoBO getUserById(Long id);
/**
*description: 分页查询
* @author: zhangzhe
 * @param userInfoQueryBO
* @return: com.cmpay.lemon.framework.page.PageInfo<com.cmpay.zz.entity.UsersDO>
* @Date: 2020/6/23 0023
*/
public PageInfo<UsersDO> findUsers(UserInfoQueryBO userInfoQueryBO);
/**
*description: 增加用户
* @author: zhangzhe
 * @param userInfoBO
* @return: void
* @Date: 2020/6/23 0023
*/
public Long save(UserInfoBO userInfoBO);
/**
*description: 删除用户
* @author: zhangzhe
 * @param id
* @return: void
* @Date: 2020/6/28 0028
*/
public void delete(Long id);
/**
* @program: UserService
* @description: 批量删除用户
* @author: zhangzhe
* @create: 2020/6/28 0028
*/
public void deleteBatch(List<Long> id);
/**
*description: 修改用户
* @author: zhangzhe
 * @param userInfoBO
* @return: void
* @Date: 2020/6/28 0028
*/
public void update(UserInfoBO userInfoBO);
/**
*description: 修改密码
* @author: zhangzhe
 * @param
* @return: void
* @Date: 2020/6/28 0028
*/
public void updatePassword( String oldPassword,String newPassword,Long userId);

}
