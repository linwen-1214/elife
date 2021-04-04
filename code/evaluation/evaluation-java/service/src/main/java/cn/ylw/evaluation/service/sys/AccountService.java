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
     * 根据登录账号获取账号信息
     * @param loginAccount 登录账号
     * @return 账号信息
     */
    Account findByLoginAccount(String loginAccount);
}
