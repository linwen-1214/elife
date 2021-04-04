package cn.ylw.evaluation.core.exception;

import cn.ylw.common.lang.ResponseStatus;

/**
 * 登录异常信息
 * @author: ylw
 * @date: 2021年04月04日 13时28分
 * @description:
 */
public enum LoginException implements ExceptionMessage {
    /**
     * Shiro 认证异常
     */
    SHIRO_LOGIN_ERROR(ResponseStatus.UNAUTHORIZED, 10000, "登录授权已过期"),
    /**
     * 账号不存在
     */
    NOT_EXISTS_ACCOUNT(ResponseStatus.UNAUTHORIZED, 10001, "账号不存在"),
    /**
     * 账号已被停用
     */
    NOT_ENABLE_ACCOUNT(ResponseStatus.UNAUTHORIZED, 10002, "账号已停用"),
    /**
     * 账号所属组织已被停用
     */
    NOT_ENABLE_ACCOUNT_ORGANIZATION(ResponseStatus.UNAUTHORIZED, 10003, "组织机构已停用"),
    /**
     * 密码不匹配
     */
    NOT_EQUALS_PASSWORD(ResponseStatus.UNAUTHORIZED, 10004, "密码错误"),
    ;

    private final ResponseStatus status;
    private final int errorCode;
    private final String message;

    LoginException(ResponseStatus status, int errorCode, String message) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
    }

    @Override
    public ResponseStatus getStatus() {
        return this.status;
    }

    @Override
    public int getCode() {
        return this.errorCode;
    }

    @Override
    public String getExMessage() {
        return this.message;
    }
}
