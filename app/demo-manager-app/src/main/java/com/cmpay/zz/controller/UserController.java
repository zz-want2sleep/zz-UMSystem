package com.cmpay.zz.controller;

//import com.cmpay.gw.codec.annotation.GatewayApi;

import com.cmpay.lemon.common.utils.BeanUtils;
import com.cmpay.lemon.framework.annotation.QueryBody;
import com.cmpay.lemon.framework.controller.BaseController;
import com.cmpay.lemon.framework.data.DefaultRspDTO;

import com.cmpay.lemon.framework.data.NoBody;
import com.cmpay.lemon.framework.page.PageInfo;
import com.cmpay.zz.bo.UserInfoBO;
import com.cmpay.zz.bo.UserInfoQueryBO;
import com.cmpay.zz.dto.*;
import com.cmpay.zz.entity.UsersDO;
import com.cmpay.zz.enums.MsgEnum;
import com.cmpay.zz.service.UserService;


import com.cmpay.zz.utils.BeanConvertUtils;
import com.rabbitmq.http.client.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.util.List;

//import javax.annotation.Resource;

/**
 * @program: UserController
 * @Author: zhangzhe
 * @create: 2020/6/22 0022
 */
@RestController
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/info/{id}")
    public DefaultRspDTO<UserInfoDTO> getUserById(@PathVariable("id") Long id) {
/**
 *description:查询用户信息
 * @author: zhangzhe
 * @param id 用户id
 * @return: com.cmpay.zz.entity.UsersDO
 * @Date: 2020/6/22 0022
 */
        return getUserInfo(id);

    }

    /**
     * description: 查询用户信息
     *
     * @param userInfoDTO
     * @author: zhangzhe
     * @return: com.cmpay.lemon.framework.data.DefaultRspDTO<com.cmpay.zz.dto.UserInfoDTO>
     * @Date: 2020/6/23 0023
     */
    @GetMapping("/user/info")
    public DefaultRspDTO<UserInfoDTO> getUserInfo(@QueryBody UserInfoDTO userInfoDTO) {
        return getUserInfo(userInfoDTO.getId());
    }

    /**
     * description: 分页查询
     *
     * @param userInfoDTOUserInfoQueryReqDTO
     * @author: zhangzhe
     * @return: com.cmpay.zz.dto.UserInfoQueryRspDTO
     * @Date: 2020/6/24 0024
     */
    @GetMapping("/user/list")
    public UserInfoQueryRspDTO getUserInfoPage(@QueryBody UserInfoQueryReqDTO userInfoDTOUserInfoQueryReqDTO) {
        UserInfoQueryBO userInfoQueryBO = new UserInfoQueryBO();
        BeanUtils.copyProperties(userInfoQueryBO, userInfoDTOUserInfoQueryReqDTO);
        PageInfo<UsersDO> page = userService.findUsers(userInfoQueryBO);

        List<UserInfoDTO> userInfos = BeanConvertUtils.convertList(page.getList(), UserInfoDTO.class);
        UserInfoQueryRspDTO userInfoQueryRspDTO = new UserInfoQueryRspDTO();
        userInfoQueryRspDTO.setList(userInfos);
        userInfoQueryRspDTO.setPageNum(page.getPageNum());
        userInfoQueryRspDTO.setPageSize(page.getPageSize());
        userInfoQueryRspDTO.setPages(page.getPages());
        userInfoQueryRspDTO.setTotal(page.getTotal());
        userInfoQueryRspDTO.setMsgCd(MsgEnum.SUCCESS.getMsgCd());
        userInfoQueryRspDTO.setMsgInfo(MsgEnum.SUCCESS.getMsgInfo());

        return userInfoQueryRspDTO;

    }

    /**
     * description: 增加用户
     *
     * @param userAddReqDTO
     * @author: zhangzhe
     * @return: com.cmpay.lemon.framework.data.DefaultRspDTO<com.cmpay.lemon.framework.data.NoBody>
     * @Date: 2020/6/23 0023
     */
    @PostMapping("/user/add")
    public DefaultRspDTO<NoBody> save(@RequestBody UserAddReqDTO userAddReqDTO) {

        UserInfoBO userInfoBO = new UserInfoBO();
        BeanUtils.copyProperties(userInfoBO, userAddReqDTO);

        Long userNo = userService.save(userInfoBO);
        return DefaultRspDTO.newSuccessInstance();
    }
/**
*description: 删除用户
* @author: zhangzhe
 * @param userDeleteDTO
* @return: com.cmpay.lemon.framework.data.DefaultRspDTO<com.cmpay.lemon.framework.data.NoBody>
* @Date: 2020/6/28 0028
*/
@PostMapping("/user/delete")
    public DefaultRspDTO<NoBody> deleteBatch(@RequestBody UserDeleteDTO userDeleteDTO) {
        userService.deleteBatch(userDeleteDTO.getId());
        return DefaultRspDTO.newSuccessInstance();
    }

    /**
    *description: 更新用户
    * @author: zhangzhe
     * @param userUpdateReqDTO
    * @return: com.cmpay.lemon.framework.data.DefaultRspDTO<com.cmpay.lemon.framework.data.NoBody>
    * @Date: 2020/6/28 0028
    */
@PostMapping("/user/update")
public DefaultRspDTO<NoBody> update(@RequestBody UserUpdateReqDTO userUpdateReqDTO){
    UserInfoBO userInfoBO = BeanUtils.copyPropertiesReturnDest(new UserInfoBO(),userUpdateReqDTO);
    userService.update(userInfoBO);
    return DefaultRspDTO.newSuccessInstance();
}
/**
*description: 更新密码
* @author: zhangzhe
 * @param userPasswordReqDTO
* @return: com.cmpay.lemon.framework.data.DefaultRspDTO<com.cmpay.lemon.framework.data.NoBody>
* @Date: 2020/6/28 0028
*/
@PostMapping("user/updatePassword")
public DefaultRspDTO<NoBody> updatePassword(@RequestBody UserPasswordReqDTO userPasswordReqDTO){
    userService.updatePassword(userPasswordReqDTO.getOldPassword(),userPasswordReqDTO.getNewPassword(),userPasswordReqDTO.getId());
    return DefaultRspDTO.newSuccessInstance();
}

    /**
     * description: 查询用户信息
     *
     * @param id 用户id
     * @author: zhangzhe
     * @return: com.cmpay.lemon.framework.data.DefaultRspDTO<com.cmpay.zz.dto.UserInfoDTO>
     * @Date: 2020/6/23 0023
     */
    private DefaultRspDTO<UserInfoDTO> getUserInfo(Long id) {
        UserInfoBO userInfoBO = new UserInfoBO();
        userInfoBO.setId(id);
        userInfoBO = userService.getUserById(userInfoBO);
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        BeanUtils.copyProperties(userInfoDTO, userInfoBO);
        return DefaultRspDTO.newSuccessInstance(userInfoDTO);
    }

}
