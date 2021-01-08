package com.zwaking.common.base;

import com.zwaking.common.utils.JsonUtils;

import lombok.Getter;

/**
 * @author waking
 * @date 2020/11/30
 */
public enum ResponseCode {
    /**
     * 请求成功
     */
    RES_CODE_C_SUCCESS("0000", "请求成功"),
    /**
     * 登录错误
     */
    RES_CODE_E_LOGIN("8000", "登录错误"),
    /**
     * 权限验证失败
     */
    RES_CODE_E_ACCESS_DENIED("8001", "权限验证失败"),
    /**
     * Token无效
     */
    RES_CODE_E_TOKEN_DENIED("8002", "Token无效"),
    /**
     * 未绑定平台账号
     */
    RES_CODE_E_LOGIN_UNBIND("8003", "未绑定平台账号"),
    /**
     * 操作失败
     */
    RES_CODE_E_OPERATION("7000", "操作失败"),
    /**
     * 用户信息不存在
     */
    RES_CODE_E_USER_NOTFOUND("7100", "用户信息不存在"),
    /**
     * 用户已绑定其他openId
     */
    RES_CODE_E_USER_BINDED("7101", "用户已绑定其他openId"),
    /**
     * 品类权限未支付
     */
    RES_CODE_E_CATEGORY_NO_PAID("6000", "品类权限未支付"),
    /**
     * 系统错误
     */
    RES_CODE_E_SYSTEM("9999", "系统错误");

    @Getter
    private String code;

    @Getter
    private String codeMsg;

    ResponseCode(String code, String codeMsg) {
        this.code = code;
        this.codeMsg = codeMsg;
    }

    @Override
    public String toString() {
        return JsonUtils.bean2JsonStr(this);
    }
}
