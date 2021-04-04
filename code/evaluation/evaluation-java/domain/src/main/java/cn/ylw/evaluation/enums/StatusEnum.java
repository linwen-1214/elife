package cn.ylw.evaluation.enums;

/**
 * 状态枚举
 *
 * @author: ylw
 * @date: 2021年04月04日 11时43分
 * @description:
 */
public enum StatusEnum {
    /**
     * 启用
     */
    ENABLE(1),
    /**
     * 停用
     */
    NOT_ENABLE(0);

    /**
     * 状态标志
     */
    private final int value;

    StatusEnum(int value) {
        this.value =value;
    }

    public int value(){
        return this.value;
    }

    public static StatusEnum valueOf(int value){
        for (StatusEnum statusEnum : StatusEnum.values()) {
            if(statusEnum.value  == value){
                return statusEnum;
            }
        }
        return null;
    }

}
