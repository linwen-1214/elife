package cn.ylw.evaluation.entity.sys;

import java.io.Serializable;

import cn.ylw.evaluation.enums.StatusEnum;
import lombok.Data;

/**
 * SYS_ORGANIZATION
 * @author 
 */
@Data
public class Organization implements Serializable {
    private static final long serialVersionUID = -6248527604734440390L;
    private String id;

    /**
     * 编码 用于进行快速查到下级机构 更改上级时,同步更新所有关联的下级机构编码的上级信息
编码规则4+4+4+4
     */
    private String code;

    /**
     * 机构编码 用户创建时自定义
     */
    private String orgCode;

    /**
     * 机构名称
     */
    private String name;

    /**
     * 上级机构Id
     */
    private String parentId;
    /**
     * 组织机构状态 0 停用 1 启用
     */
    private StatusEnum status;

    /**
     * 地区/地址
     */
    private String area;

    /**
     * 机构联系人
     */
    private String contactPerson;

    /**
     * 机构联系电话
     */
    private String contactPhone;

    /**
     * 机构联系邮箱
     */
    private String contactEmail;

}