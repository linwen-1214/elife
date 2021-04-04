package cn.ylw.evaluation.entity.sys;

import java.io.Serializable;
import java.util.Date;

import cn.ylw.evaluation.enums.StatusEnum;
import lombok.Data;

/**
 * SYS_ROLE
 *
 * @author
 */
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -5032328284530595358L;
    /**
     * 角色主键
     */
    private String id;

    /**
     * 角色编码 用于进行快速查到下级角色 更改上级时,同步更新所有关联的下级角色编码的上级信息
     * 编码规则4+4+4+4
     */
    private String code;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 上级角色ID
     */
    private String parentId;

    /**
     * 角色状态 0 停用 1 启用
     */
    private StatusEnum status;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建操作账号
     */
    private String createAccountId;

}