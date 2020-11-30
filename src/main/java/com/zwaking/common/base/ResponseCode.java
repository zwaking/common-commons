package com.zwaking.common.base;

/**
 * @author waking
 * @date 2020/11/30
 */
public enum ResponseCode {
    /**
     * 请求成功
     */
    RES_CODE_C_SUCCESS("0000"),
    /**
     * 登录错误
     */
    RES_CODE_E_LOGIN("8000"),
    /**
     * 权限验证失败
     */
    RES_CODE_E_ACCESS_DENIED("8001"),
    /**
     * Token无效
     */
    RES_CODE_E_TOKEN_DENIED("8002"),
    /**
     * 系统错误
     */
    RES_CODE_E_SYSTEM("9999");

    private String code;

    ResponseCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
