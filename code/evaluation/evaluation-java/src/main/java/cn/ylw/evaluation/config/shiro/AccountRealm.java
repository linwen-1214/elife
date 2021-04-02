package cn.ylw.evaluation.config.shiro;

import cn.hutool.core.bean.BeanUtil;
import cn.ylw.evaluation.common.util.ShiroPasswordUtils;
import cn.ylw.evaluation.entity.sys.Account;
import cn.ylw.evaluation.service.sys.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: ylw
 * @date: 2021年04月02日 09时00分
 * @description:
 */
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccountRealm extends AuthorizingRealm {
    private final JwtUtils jwtUtils;
    private final AccountService accountService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
         JwtToken jwt = (JwtToken) authenticationToken;
        log.info("jwt----------------->{}", jwt);
        String accountId = jwtUtils.getClaimByToken((String) jwt.getPrincipal()).getSubject();
//        Account user = accountService.findById(Long.parseLong(userId));
//        if(user == null) {
//            throw new UnknownAccountException("账户不存在！");
//        }
//        if(user.getStatus() == -1) {
//            throw new LockedAccountException("账户已被锁定！");
//        }
//        AccountProfile profile = new AccountProfile();
//        BeanUtil.copyProperties(user, profile);
//        log.info("profile----------------->{}", profile.toString());
//        return new SimpleAuthenticationInfo(profile, jwt.getCredentials(), getName());
        Account account = new Account();
        account.setLoginAccount(accountId);
        return new SimpleAuthenticationInfo(account, ShiroPasswordUtils.encrypt("account.getPassword()",accountId), ByteSource.Util.bytes(account.getLoginAccount()), getName());
    }
}
