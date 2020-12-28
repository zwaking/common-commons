package com.zwaking.common.exception;

import com.zwaking.common.base.ResponseCode;

/**
 * @author waking
 * @date 2020/11/25 11:25
 */
public class BizException extends RuntimeException {

    private ResponseCode responseCode = ResponseCode.RES_CODE_E_SYSTEM;

    public BizException(ResponseCode responseCode) {
        super("BusinessException[responseCode=" + responseCode + "]");
        this.responseCode = responseCode;
    }

    public BizException(ResponseCode responseCode, String message) {
        super("BusinessException[responseCode=" + responseCode + ",message=" + message + "]");
    }

    private BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public static BizException getBizException(ResponseCode responseCode, String message, Throwable cause) {
        message = "BusinessException[responseCode=" + responseCode + ",message=" + message + "]";
        return new BizException(message, cause);
    }
}
