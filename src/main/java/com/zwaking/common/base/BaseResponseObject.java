package com.zwaking.common.base;

/**
 * @author waking
 * @date 2020/11/30
 */
public class BaseResponseObject<T> extends BaseObject {

    /**
     * 请求成功
     */
    public final static String RES_CODE_C_SUCCESS = "0000";
    /**
     * 系统错误
     */
    public final static String RES_CODE_E_SYSTEM = "9999";
    /**
     * 登录错误
     */
    public final static String RES_CODE_E_LOGIN = "8000";
    /**
     * 权限验证失败
     */
    public final static String RES_CODE_E_ACCESS_DENIED = "8001";

    private String resCode;
    private String resMsg;
    private T resBody;

    public String getResCode() {
        return resCode;
    }

    public void setResCode(ResponseCode resCode) {
        this.resCode = resCode.getCode();
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public T getResBody() {
        return resBody;
    }

    public void setResBody(T resBody) {
        this.resBody = resBody;
    }
}
