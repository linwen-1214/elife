package cn.ylw.common.lang;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回数据结果格式
 *
 * @author: ylw
 * @date: 2021年04月01日 15时19分
 * @description:
 */
@Data
@Builder
public class ResponseResult implements Serializable {
    /**
     * 请求状态码
     */
    private int code;
    /**
     * 具体返回错误状态信息
     */
    private int errorCode;

    /**
     * 返回信息说明
     */
    private String msg;
    /**
     * 返回数据结果
     */
    private Object data;
    public static ResponseResult success() {
        return success(null, null);
    }
    public static ResponseResult success(Object data) {
        return success(null, data);
    }

    public static ResponseResult success(String msg, Object data) {
        return resultBuilder(ResponseStatus.OK.value(),ResponseStatus.OK.value(), msg, data);
    }

    public static ResponseResult fail(int errorCode,String msg) {
        return fail(errorCode,msg, null);
    }

    public static ResponseResult fail(int errorCode,String msg, Object data) {
        return fail(ResponseStatus.SERVER_ERROR,errorCode, msg, data);
    }

    public static ResponseResult fail(ResponseStatus ResponseStatus, int errorCode, String msg) {
        return fail(ResponseStatus, errorCode,msg, null);
    }

    public static ResponseResult fail(ResponseStatus ResponseStatus, int errorCode, String msg, Object data) {
        return resultBuilder(ResponseStatus.value(),errorCode, msg, data);
    }

    private static ResponseResult resultBuilder(int code,int errorCode, String msg, Object data) {
        return ResponseResult.builder().code(code).errorCode(errorCode).msg(msg).data(data).build();
    }

}
