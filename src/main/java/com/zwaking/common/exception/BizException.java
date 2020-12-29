package com.zwaking.common.exception;

import com.zwaking.common.base.ResponseCode;

import lombok.Getter;

/**
 * @author waking
 * @date 2020/11/25 11:25
 */
public class BizException extends RuntimeException {

    @Getter
    private ResponseCode responseCode;

    public BizException(ResponseCode responseCode) {
        super(responseCode.getCodeMsg());
        this.responseCode = responseCode;
    }

    public BizException(ResponseCode responseCode, String message) {
        super(message);
        this.responseCode = responseCode;
    }

    private BizException(ResponseCode responseCode, String message, Throwable cause) {
        super(message, cause);
        this.responseCode = responseCode;
    }

    public static BizException getNewInstanse(String message) {
        return new BizException(ResponseCode.RES_CODE_E_OPERATION, message);
    }

    public static BizException getNewInstanse(String message, Throwable cause) {
        return BizException.getNewInstanse(ResponseCode.RES_CODE_E_OPERATION, message, cause);
    }

    public static BizException getNewInstanse(ResponseCode responseCode, String message, Throwable cause) {
        return new BizException(responseCode, message, cause);
    }
}
