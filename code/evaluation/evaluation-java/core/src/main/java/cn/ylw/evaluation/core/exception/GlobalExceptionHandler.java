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
        return ResponseResult.fail(ResponseStatus.UNAUTHORIZED, e.getMessage(), null);
    }

    @ExceptionHandler(UnauthenticatedException.class)
    public ResponseResult handleShiroUnauthenticated(ShiroException e) {
        return ResponseResult.fail(ResponseStatus.UNAUTHORIZED, "未登录授权,请先登录!", null);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseResult handlerRuntime(RuntimeException e) throws IOException {
        log.error("运行时异常:-------------->", e);
        return ResponseResult.fail(ResponseStatus.SERVER_ERROR, e.getMessage());
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseResult handler(Exception e) throws IOException {
        return ResponseResult.fail(ResponseStatus.SERVER_ERROR, e.getMessage());
    }
}
