package com.cmpay.zz.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
* @program: UserInfoQueryRspDTO
* @description: 分页响应结果对象
* @author: zhangzhe
* @create: 2020/6/23 0023
*/
@EqualsAndHashCode(callSuper = true)
@Data
public class UserInfoQueryRspDTO extends PageableRspDTO {

    private List<UserInfoDTO> list;

}
