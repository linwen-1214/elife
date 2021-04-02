package cn.ylw.evaluation.exception;

import cn.ylw.evaluation.common.lang.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public ResponseResult handleShiro(ShiroException e) {
        return ResponseResult.fail(HttpStatus.UNAUTHORIZED, e.getMessage(), null);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthenticatedException.class)
    public ResponseResult handleShiroUnauthenticated(ShiroException e) {
        return ResponseResult.fail(HttpStatus.UNAUTHORIZED, "未登录授权,请先登录!", null);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseResult handlerRuntime(RuntimeException e) throws IOException {
        log.error("运行时异常:-------------->", e);
        return ResponseResult.fail(HttpStatus.BAD_REQUEST, e.getMessage());
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseResult handler(Exception e) throws IOException {
        return ResponseResult.fail(HttpStatus.BAD_REQUEST, e.getMessage());
    }
}
