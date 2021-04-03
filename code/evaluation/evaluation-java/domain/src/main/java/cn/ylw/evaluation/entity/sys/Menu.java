package cn.ylw.evaluation.entity.sys;

import java.io.Serializable;
import lombok.Data;

/**
 * SYS_MENU
 * @author 
 */
@Data
public class Menu implements Serializable {
    private static final long serialVersionUID = 8599197993452251729L;
    private String id;
    /**
     * 菜单Url
     */
    private String path;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 菜单状态 0 停用 1 启用
     */
    private Short status;

    /**
     * 上级菜单Id
     */
    private String parentId;

    /**
     * 菜单类型   0 目录 1 菜单 2 按钮
     */
    private Short type;

    /**
     * 菜单排序索引
     */
    private Short orderIndex;

    /**
     * 菜单面包屑
     */
    private String breadCrumb;

    /**
     * Shiro权限标识
     */
    private String authority;

}