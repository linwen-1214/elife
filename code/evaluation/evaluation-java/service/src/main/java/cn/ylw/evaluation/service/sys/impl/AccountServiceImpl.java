package cn.ylw.evaluation.service.sys.impl;

import cn.ylw.evaluation.core.exception.LoginException;
import cn.ylw.evaluation.core.exception.OperationException;
import cn.ylw.evaluation.core.util.ShiroPasswordUtils;
import cn.ylw.evaluation.dao.sys.AccountDao;
import cn.ylw.evaluation.entity.sys.Account;
import cn.ylw.evaluation.enums.StatusEnum;
import cn.ylw.evaluation.service.sys.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

/**
 * @author: ylw
 * @date: 2021年04月01日 19时25分
 * @description:
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccountServiceImpl extends ServiceImpl implements AccountService {
    private final AccountDao accountDao;

    @Override
    public Account findByLoginAccount(String loginAccount) {
        return accountDao.findByLoginAccount(loginAccount);
    }
}
