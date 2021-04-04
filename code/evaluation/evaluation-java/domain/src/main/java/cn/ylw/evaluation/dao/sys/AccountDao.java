package cn.ylw.evaluation.dao.sys;

import cn.ylw.evaluation.dao.CommonDao;
import cn.ylw.evaluation.entity.sys.Account;

/**
 * @author ylw
 */
public interface AccountDao extends CommonDao<Account,String> {

    /**
     * 根据登录账号 查找账号信息
     * @param loginAccount 登录账号
     * @return
     */
    Account findByLoginAccount(String loginAccount);
}