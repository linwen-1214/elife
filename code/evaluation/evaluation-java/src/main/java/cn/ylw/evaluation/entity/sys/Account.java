package cn.ylw.evaluation.entity.sys;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * SYS_ACCOUNT
 * @author 
 */
@Data
public class Account implements Serializable {
    /**
     * 账号Id
     */
    private String id;

    /**
     * 账号所属组织机构Id
     */
    private String orgId;

    /**
     * 登录账号
     */
    private String loginAccount;

    /**
     * 账号名称
     */
    private String name;

    /**
     * 账号头像
     */
    private String avatar;

    /**
     * 账号邮箱
     */
    private String email;

    /**
     * 账号密码
     */
    private String password;

    /**
     * 账号手机号码
     */
    private String phone;

    /**
     * 账号状态 0 停用 1 启用
     */
    private Short status;

    /**
     * 账号创建时间
     */
    private Date createDate;

    /**
     * 账号创建人Id
     */
    private String createAccountId;

    /**
     * 账号创建人名称
     */
    private String createAccountName;

    private static final long serialVersionUID = 1L;
}