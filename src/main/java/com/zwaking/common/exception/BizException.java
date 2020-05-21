package com.zwaking.common.exception;

public class BizException extends RuntimeException {

    private long exceptionId = -1;

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(long exceptionId) {
        super("BusinessException[exId=" + exceptionId + "]");

        this.exceptionId = exceptionId;
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(long exceptionId, Throwable cause) {
        super("BusinessException[exId=" + exceptionId + "]", cause);
    }

    public long getExceptionId() {
        return exceptionId;
    }
}
