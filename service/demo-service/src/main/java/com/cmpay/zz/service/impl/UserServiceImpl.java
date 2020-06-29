package com.cmpay.zz.service.impl;

import com.alibaba.druid.sql.visitor.functions.If;
import com.cmpay.lemon.common.exception.BusinessException;
import com.cmpay.lemon.common.utils.BeanUtils;
import com.cmpay.lemon.common.utils.JudgeUtils;
import com.cmpay.lemon.framework.page.PageInfo;
import com.cmpay.lemon.framework.service.BaseService;
import com.cmpay.lemon.framework.utils.IdGenUtils;
import com.cmpay.lemon.framework.utils.PageUtils;
import com.cmpay.zz.bo.UserInfoBO;
import com.cmpay.zz.bo.UserInfoQueryBO;
import com.cmpay.zz.dao.IUsersDao;
import com.cmpay.zz.entity.UsersDO;
import com.cmpay.zz.enums.MsgEnum;
import com.cmpay.zz.service.UserService;


import com.cmpay.zz.utils.CryptoUtils;
import com.sun.jersey.core.spi.scanning.uri.BundleSchemeScanner;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
* @program: UserServiceImpl
* @Author: zhangzhe
* @create: 2020/6/22 0022
*/
@Service
public class UserServiceImpl extends BaseService implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUsersDao userDao;

    @Override
    public UserInfoBO getUserById(UserInfoBO userInfoBO) {

        UsersDO users = (UsersDO) userDao.get(userInfoBO.getId());
        BeanUtils.copyProperties(userInfoBO, users);
        return userInfoBO;
    }
/**
*description: 分页查询
* @author: zhangzhe
 * @param userInfoQueryBO
* @return: com.github.pagehelper.PageInfo<com.cmpay.zz.entity.UsersDO>
* @Date: 2020/6/23 0023
*/
    @Override
    public PageInfo<UsersDO> findUsers(UserInfoQueryBO userInfoQueryBO) {
        UsersDO usersDO = new UsersDO();
        BeanUtils.copyProperties(usersDO,userInfoQueryBO);
        return PageUtils.pageQueryWithCount(userInfoQueryBO.getPageNum(),userInfoQueryBO.getPageSize(),()->userDao.find(usersDO));
    }
/**
*description: 增加用户
* @author: zhangzhe
 * @param userInfoBO
* @return: void
* @Date: 2020/6/23 0023
*/
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Long save(UserInfoBO userInfoBO) {
        //避免用户名重复
        UsersDO userByName = userDao.getUserByName(userInfoBO.getLoginName());
        if (userByName != null) {
            BusinessException.throwBusinessException(MsgEnum.USER_DUPLICATE);
        }
        String salt = RandomStringUtils.randomAlphanumeric(20);
        String password = CryptoUtils.sha256Hash(userInfoBO.getPassword(), salt);
        //自动生成id
        String gen = IdGenUtils.generateId("TEST_IDGEN");
        Long userNo = Long.valueOf(gen);



userInfoBO.setId(userNo);
userInfoBO.setPassword(password);
//userInfoBO.setLoginName(userInfoBO.getLoginName());
//userInfoBO.setCreateBy(userInfoBO.getCreateBy());
userInfoBO.setCreateDate(LocalDateTime.now());
        logger.info("==========================="+password+"======================"+userNo);
        UsersDO userDO = BeanUtils.copyPropertiesReturnDest(new UsersDO(), userInfoBO);
int res  = userDao.insert(userDO);
if(res!=1){
    BusinessException.throwBusinessException(MsgEnum.DB_INSERT_FAILED);
}
return userNo;
    }

    /**
    *description: 删除用户
    * @author: zhangzhe
     * @param id
    * @return: void
    * @Date: 2020/6/28 0028
    */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Long id) {
int res = userDao.delete(id);
if(res!=1){
    BusinessException.throwBusinessException(MsgEnum.DB_DELETE_FAILED);
}
    }
/**
*description: 批量删除用户
* @author: zhangzhe
 * @param userNos
* @return: void
* @Date: 2020/6/28 0028
*/
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteBatch(List<Long> userNos) {
        Optional.of(userNos).ifPresent(l -> l.forEach(id -> delete(id)));
    }
/**
*description: 修改用户
* @author: zhangzhe
 * @param userInfoBO
* @return: void
* @Date: 2020/6/28 0028
*/
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void update(UserInfoBO userInfoBO) {
        if (JudgeUtils.isBlank(userInfoBO.getPassword())) {
            userInfoBO.setPassword(null);
        } else {
            String salt = RandomStringUtils.randomAlphanumeric(20);
            String password = CryptoUtils.sha256Hash(userInfoBO.getPassword(), salt);
            userInfoBO.setPassword(password);
        }
        userInfoBO.setUpdateDate(LocalDateTime.now());
        //暂时没有从session中取得update_by的业务功能

        UsersDO usersDO = BeanUtils.copyPropertiesReturnDest(new UsersDO(),userInfoBO);
        int res = userDao.update(usersDO);
        if (res != 1) {
            BusinessException.throwBusinessException(MsgEnum.DB_UPDATE_FAILED);
        }
    }

    /**
    *description: 更新密码
    * @author: zhangzhe
     * @param oldPassword
 * @param newPassword
    * @return: void
    * @Date: 2020/6/28 0028
    */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void updatePassword(String oldPassword, String newPassword,Long id) {
        //hack一下
        UsersDO usersDO =  userDao.get(id);
        if(usersDO==null){
            BusinessException.throwBusinessException(MsgEnum.USER_NOT_EXISTS);
        }
//需要在users表中加上盐salt字段反向，而不是现在随机生成！！！！
//        if(!usersDO.getPassword().equals(CryptoUtils.sha256Hash(newPassword,salt))){
//            BusinessException.throwBusinessException(MsgEnum.DB_PASSWORDUPDATE_FAILED);
//        }
        Map<String,Object> map = new HashMap();
        map.put("oldPassword",oldPassword);
        String salt = RandomStringUtils.randomAlphanumeric(20);
        newPassword = CryptoUtils.sha256Hash(newPassword,salt);
        map.put("newPassword",newPassword);
        map.put("id",id);
   int res= userDao.updatePassword(map);
   if(res!=1){
       BusinessException.throwBusinessException(MsgEnum.DB_UPDATE_FAILED);
   }
    }


}
