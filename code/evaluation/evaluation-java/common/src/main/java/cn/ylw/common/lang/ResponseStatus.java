package cn.ylw.common.lang;

/**
 * 返回接口状态
 * @author: ylw
 * @date: 2021年04月03日 17时51分
 * @description:
 */
public enum ResponseStatus {
    /**
     * 请求成功
     */
    OK(200),
    /**
     * 服务错误
     */
    SERVER_ERROR(500),
    /**
     * 认证错误(需要重新登录)
     */
    UNAUTHORIZED(401);



    private final int value;
    ResponseStatus(int value ){
        this.value = value;
    }

    public int value(){
        return this.value;
    }

}
