package cn.ylw.evaluation.core.exception;

import cn.ylw.common.lang.ResponseResult;
import cn.ylw.common.lang.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

/**
 * 全局异常处理
 *
 * @author: ylw
 * @date: 2021年04月02日 13时32分
 * @description:
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 捕捉shiro的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ShiroException.class)
    public ResponseResult handleShiro(ShiroException e) {
        log.error("Shiro Exception ", e);
        return ResponseResult.fail(ResponseStatus.UNAUTHORIZED, ResponseStatus.UNAUTHORIZED.value(), e.getMessage(), null);
    }

    @ExceptionHandler(OperationException.class)
    public ResponseResult operation(OperationException e) {
        log.error("OperationException Exception ", e);
        return ResponseResult.fail(e.getStatus(), e.getCode(), e.getExMessage(), null);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseResult handler(Exception e) {
        log.error("Other Exception ", e);
        return ResponseResult.fail(ResponseStatus.SERVER_ERROR, ResponseStatus.SERVER_ERROR.value(), e.getMessage());
    }
}
