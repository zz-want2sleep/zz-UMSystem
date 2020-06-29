package com.cmpay.zz.auth;

import com.cmpay.lemon.common.exception.LemonException;
import com.cmpay.lemon.framework.security.SimpleUserInfo;
import com.cmpay.lemon.framework.security.UserInfoBase;
import com.cmpay.lemon.framework.security.auth.AbstractGenericMatchableAuthenticationProcessor;
import com.cmpay.lemon.framework.security.auth.GenericAuthenticationToken;

import com.cmpay.zz.bo.UserInfoBO;
import com.cmpay.zz.enums.MsgEnum;

import com.cmpay.zz.service.LoginService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
/**
* @program: LoginAuthenticationProcessor
* @description: 登录认证类
* @author: zhangzhe
* @create: 2020/6/23 0023
*/
public class LoginAuthenticationProcessor  extends AbstractGenericMatchableAuthenticationProcessor<GenericAuthenticationToken> {
    @Autowired
    private LoginService loginService;
    Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * @param filterProcessesUrl 认证Url, 前缀必须与GenericAuthenticationFilter拦截的Url前缀一致
     */
    /**
    *description:
    * @author: zhangzhe
     * @param filterProcessesUrl 认证Url, 前缀必须与GenericAuthenticationFilter拦截的Url前缀一致
    * @return:
    * @Date: 2020/6/23 0023
    */
    public LoginAuthenticationProcessor(String filterProcessesUrl) {
        super(filterProcessesUrl);
    }

    @Override
    protected UserInfoBase doProcessAuthentication(GenericAuthenticationToken genericAuthenticationToken) throws AuthenticationException {

        HttpServletRequest request = genericAuthenticationToken.getAuthenticationRequest().getHttpServletRequest();
        UserInfoBO userInfoBO = bindLoginData(request);
        UserInfoBO login = loginService.login(userInfoBO);
        System.out.println(login.getId().toString()+login.getLoginName()+login.getPassword());
        return new SimpleUserInfo(login.getId().toString(),login.getLoginName(),login.getPassword());
    }

/**
*description:
* @author: zhangzhe
 * @param request http请求
* @return: com.cmpay.zz.bo.UserInfoBO
* @Date: 2020/6/23 0023
*/
    private UserInfoBO bindLoginData(HttpServletRequest request) {

        UserInfoBO userLoginBO = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {

            InputStream is = request.getInputStream();
            userLoginBO = objectMapper.readValue(is, UserInfoBO.class);

            System.out.println(userLoginBO);
        } catch (IOException e) {
            throw LemonException.create(e);
        } catch (Exception e) {
            LemonException.throwLemonException(MsgEnum.FAIL, e.getMessage());
        }
        return userLoginBO;
    }
}
