package cn.ylw.evaluation.core.exception;

import cn.ylw.common.lang.ResponseStatus;
import lombok.Getter;

/**
 * @author: ylw
 * @date: 2021年04月04日 12时53分
 * @description:
 */
public class OperationException extends RuntimeException implements ExceptionMessage{
    private static final long serialVersionUID = -2181373722965792824L;

    @Getter
    private ExceptionMessage exceptionMessage;
    @Getter
    private Object attachInfo;

    public OperationException(ExceptionMessage errorMessage, Throwable cause, Object attachInfo) {
        super(errorMessage.getExMessage(), cause);
        this.exceptionMessage = errorMessage;
        this.attachInfo = attachInfo;
    }

    public OperationException(ExceptionMessage errorMessage) {
        this(errorMessage, null, null);

    }

    public OperationException(ExceptionMessage errorMessage, Throwable cause) {
        this(errorMessage, cause, null);
    }

    public OperationException(ExceptionMessage errorMessage, Object attachInfo) {
        this(errorMessage, null, attachInfo);
    }


    @Override
    public ResponseStatus getStatus() {
        return exceptionMessage.getStatus();
    }

    @Override
    public int getCode() {
        return exceptionMessage.getCode();
    }

    @Override
    public String getExMessage() {
        return exceptionMessage.getExMessage();
    }
}
