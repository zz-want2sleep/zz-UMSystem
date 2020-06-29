package com.cmpay.zz.service;

import com.cmpay.zz.bo.UserInfoBO;
import org.springframework.stereotype.Service;

/**
* @program: LoginService
* @description:用户登录服务
* @author: zhangzhe
* @create: 2020/6/23 0023
*/
@Service
public interface LoginService {
    /**
    *description: 用户登录
    * @author: zhangzhe
     * @param userInfoBO 用户信息实体类参数
    * @return: com.cmpay.zz.bo.UserInfoBO
    * @Date: 2020/6/23 0023
    */
    public UserInfoBO login(UserInfoBO userInfoBO);
}
