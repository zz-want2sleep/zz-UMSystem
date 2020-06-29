package com.cmpay.zz.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* @program: UserInfoQueryReqDTO
* @description: 分页请求参数对象
* @author: zhangzhe
* @create: 2020/6/23 0023
*/
@EqualsAndHashCode(callSuper = true)
@Data
public class UserInfoQueryReqDTO extends PageableRspDTO {

    private String loginName;

}
