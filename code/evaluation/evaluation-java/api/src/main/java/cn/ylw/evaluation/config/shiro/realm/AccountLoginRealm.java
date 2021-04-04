package cn.ylw.evaluation.config.shiro.realm;

import cn.ylw.evaluation.core.exception.LoginException;
import cn.ylw.evaluation.core.exception.OperationException;
import cn.ylw.evaluation.core.util.ShiroPasswordUtils;
import cn.ylw.evaluation.entity.sys.Account;
import cn.ylw.evaluation.enums.StatusEnum;
import cn.ylw.evaluation.service.sys.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: ylw
 * @date: 2021年04月04日 16时21分
 * @description:
 */
@Slf4j
public class AccountLoginRealm extends AuthorizingRealm {
    @Autowired
    private AccountService accountService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        Account account = accountService.findByLoginAccount(username);
        if (account == null) {
            throw new UnknownAccountException();
        }
        if(StatusEnum.NOT_ENABLE.equals(account.getStatus())){
            throw new LockedAccountException();
        }
        if(StatusEnum.NOT_ENABLE.equals(account.getOrganization().getStatus())){
            throw new DisabledAccountException();
        }
        return new SimpleAuthenticationInfo(account, account.getPassword(), ByteSource.Util.bytes(account.getLoginAccount()), getName());
    }
}
