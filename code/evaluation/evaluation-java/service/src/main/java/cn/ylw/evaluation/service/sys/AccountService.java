package cn.ylw.evaluation.service.sys;

import cn.ylw.evaluation.entity.sys.Account;

/**
 * 角色权限信息
 * @author: ylw
 * @date: 2021年04月01日 19时25分
 * @description:
 */
public interface AccountService{

    /**
     * 验证登录信息
     * 验证账号是否存在
     * 验证账号是否启用
     * 验证账号所属组织机构是否启用
     * 验证密码是否匹配
     * @param loginAccount 登录账号
     * @param password 登录密码
     * @return
     */
    Account verifyLogin(String loginAccount,String password);
    /**
     * 根据登录账号获取账号信息
     * @param loginAccount 登录账号
     * @return 账号信息
     */
    Account findByLoginAccount(String loginAccount);
}
