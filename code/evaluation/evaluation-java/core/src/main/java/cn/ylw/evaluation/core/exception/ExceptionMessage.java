package cn.ylw.evaluation.core.exception;

import cn.ylw.common.lang.ResponseStatus;

/**
 * @author: ylw
 * @date: 2021年04月04日 12时46分
 * @description:
 */
public interface ExceptionMessage {

    /**
     * 返回消息状态
     * @return
     */
    ResponseStatus getStatus();
    /**
     * 异常信息编码
     * 异常信息编码总长度为6位，
     * 前两位表示业务模块比如 10 表示登录模块 11 表示系统管理模块 12 表示业务管理模块
     * 中间两位表示 模块代表的业务编码 比如 1000 表示登录校验业务 1001 表示系统退出业务
     * 最后两位表示具体的异常消息编码
     * 定义枚举异常信息时，按照顺序排序进行定义
     * @return
     */
    int getCode();

    /**
     * 异常信息说明
     * @return
     */
    String getExMessage();
}
