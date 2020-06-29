package com.cmpay.zz.enums;

import com.cmpay.lemon.common.AlertCapable;
import org.apache.commons.lang3.StringUtils;

/**
 * 描述
 * @author : Noone
 */
public enum MsgEnum implements AlertCapable {
    /**
     * SUCCESS
     */
    SUCCESS("TST00000", "交易成功"),

    USER_DUPLICATE("TST00601","用户名重复"),
    USER_NOT_EXISTS("TST00602","用户不存在"),
    ROLE_NOT_EXISTS("TST00702","角色不存在"),
    DB_INSERT_FAILED("TST00102", "数据新增失败"),
    DB_DELETE_FAILED("TST00101", "数据删除失败"),
    DB_UPDATE_FAILED("TST00100", "数据更新失败"),
    DB_PASSWORDUPDATE_FAILED("TST00103","原密码不匹配"),
    LOGIN_SESSION_EXPIRE("TST00003", "账号过期，请重新登录"),
    ORGIN_PASSWORD_NOT_CORRECT("TST00006","原密码错误"),
    FAIL("TST00999","登录失败"),


    ;

    /**
     * 错误码
     */
    private String msgCd;

    /**
     * 错误消息
     */
    private String msgInfo;

    MsgEnum(String msgCd, String msgInfo) {
        this.msgCd = msgCd;
        this.msgInfo = msgInfo;
    }

    public static MsgEnum getEnum(String msgCd) {
        for (MsgEnum m : MsgEnum.values()) {
            if (StringUtils.equals( m.msgCd, msgCd )) {
                return m;
            }
        }
        return null;
    }

    @Override
    public String getMsgCd() {
        return msgCd;
    }

    @Override
    public String getMsgInfo() {
        return msgInfo;
    }
}
