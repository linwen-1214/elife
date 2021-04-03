package cn.ylw.evaluation.entity.sys;

import java.io.Serializable;
import lombok.Data;

/**
 * SYS_ACCOUNT_ROLE
 * @author 
 */
@Data
public class AccountRole implements Serializable {
    private static final long serialVersionUID = -2003055048731836366L;
    private String id;

    /**
     * 账号Id
     */
    private String accountId;

    /**
     * 角色Id
     */
    private String roleId;

}