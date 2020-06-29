package com.cmpay.zz.service.impl;

import com.cmpay.lemon.framework.service.BaseService;
import com.cmpay.zz.bo.UserInfoBO;
import com.cmpay.zz.dao.IUsersDao;
import com.cmpay.zz.entity.UsersDO;
import com.cmpay.zz.service.LoginService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
* @program: LoginServiceImpl
* @description: 用户登录
* @author: zhangzhe
* @create: 2020/6/23 0023
*/
@Service
public class LoginServiceImpl  extends BaseService implements LoginService{
    @Autowired
    private IUsersDao usersDao;
    @Override
    public UserInfoBO login(UserInfoBO userInfoBO) {
        UsersDO login = usersDao.Login(userInfoBO.getLoginName(), userInfoBO.getPassword());
        UserInfoBO userInfoBoTow = new UserInfoBO();
        System.out.println(login);
        BeanUtils.copyProperties(login,userInfoBoTow);
        return userInfoBoTow;
    }
}
