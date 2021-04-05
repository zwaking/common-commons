package com.zwaking.common.base;

/**
 * @title http协议返回信息的基础类
 * @author waking
 * @date 2020/11/30
 */
public class BaseResponseObject<T> extends BaseObject {

    private String resCode;
    private String resMsg;
    private T resBody;

    public BaseResponseObject() {
        this.resCode = ResponseCode.RES_CODE_C_SUCCESS.getCode();
        this.resMsg = ResponseCode.RES_CODE_C_SUCCESS.getCodeMsg();
    }

    public BaseResponseObject(T t) {
        this();
        this.resBody = t;
    }

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
