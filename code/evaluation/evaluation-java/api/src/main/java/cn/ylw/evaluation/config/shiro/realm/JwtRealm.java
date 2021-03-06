package cn.ylw.evaluation.config.shiro.realm;

import cn.ylw.common.constant.JwtConstants;
import cn.ylw.evaluation.config.shiro.token.JwtToken;
import cn.ylw.common.util.JwtUtils;
import cn.ylw.evaluation.entity.sys.Account;
import cn.ylw.evaluation.service.sys.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: ylw
 * @date: 2021年04月02日 09时00分
 * @description:
 */
@Slf4j
public class JwtRealm extends AuthorizingRealm {
    @Autowired
    private AccountService accountService;

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
        String loginAccount = JwtUtils.getClaimByToken((String) jwt.getPrincipal(), JwtConstants.KEY).getSubject();
        Account account = accountService.findByLoginAccount(loginAccount);
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

        return new SimpleAuthenticationInfo(account, jwt.getCredentials(), getName());
    }
}
