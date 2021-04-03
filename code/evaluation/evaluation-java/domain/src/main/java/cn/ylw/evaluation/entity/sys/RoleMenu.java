package cn.ylw.evaluation.entity.sys;

import java.io.Serializable;
import lombok.Data;

/**
 * SYS_ROLE_MENU
 * @author 
 */
@Data
public class RoleMenu implements Serializable {
    private static final long serialVersionUID = 6567595534920084479L;
    private String id;

    /**
     * 角色Id
     */
    private String roleId;

    /**
     * 菜单ID
     */
    private String menuId;

}