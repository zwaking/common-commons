package com.zwaking.common.exception;

public class SBizException extends Exception {
    private static final long serialVersionUID = 1L;

    private long exceptionId = -1;

    public SBizException() {
        super();
    }

    public SBizException(String message) {
        super(message);
    }

    public SBizException(long exceptionId) {
        super("BusinessException[exId=" + exceptionId + "]");

        this.exceptionId = exceptionId;
    }

    public SBizException(Throwable cause) {
        super(cause);
    }

    public SBizException(String message, Throwable cause) {
        super(message, cause);
    }

    public SBizException(long exceptionId, Throwable cause) {
        super("BusinessException[exId=" + exceptionId + "]", cause);
    }

    public long getExceptionId() {
        return exceptionId;
    }
}
