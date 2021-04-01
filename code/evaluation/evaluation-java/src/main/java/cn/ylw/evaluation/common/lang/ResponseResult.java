package cn.ylw.evaluation.common.lang;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

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
     * 返回信息说明
     */
    private String msg;
    /**
     * 返回数据结果
     */
    private Object data;

    public static ResponseResult success(Object data) {
        return success(null, data);
    }

    public static ResponseResult success(String msg, Object data) {
        return resultBuilder(HttpStatus.OK.value(), msg, data);
    }

    public static ResponseResult fail(String msg) {
        return fail(msg, null);
    }

    public static ResponseResult fail(String msg, Object data) {
        return fail(HttpStatus.INTERNAL_SERVER_ERROR, msg, data);
    }

    public static ResponseResult fail(HttpStatus httpStatus, String msg) {
        return fail(httpStatus, msg, null);
    }

    public static ResponseResult fail(HttpStatus httpStatus, String msg, Object data) {
        return resultBuilder(httpStatus.value(), msg, data);
    }

    private static ResponseResult resultBuilder(int code, String msg, Object data) {
        return ResponseResult.builder().code(code).msg(msg).data(data).build();
    }

}
