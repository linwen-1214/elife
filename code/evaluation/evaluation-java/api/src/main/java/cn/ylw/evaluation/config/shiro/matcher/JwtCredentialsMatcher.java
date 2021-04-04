package cn.ylw.evaluation.config.shiro.matcher;

import cn.ylw.common.constant.JwtConstants;
import cn.ylw.common.util.JwtUtils;
import cn.ylw.evaluation.entity.sys.Account;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

/**
 * @author: ylw
 * @date: 2021年04月04日 16时11分
 * @description:
 */
@Slf4j
public class JwtCredentialsMatcher implements CredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        String token = (String) authenticationToken.getCredentials();
        Object stored = authenticationInfo.getCredentials();
        String salt = stored.toString();
        Account user = (Account) authenticationInfo.getPrincipals().getPrimaryPrincipal();
        try {
            boolean tokenExpired = JwtUtils.isTokenExpired(token, JwtConstants.KEY);
            return tokenExpired;
//            Algorithm algorithm = Algorithm.HMAC256(salt);
//            JWTVerifier verifier = JWT.require(algorithm)
//                    .withClaim("username", user.getUsername())
//                    .build();
//            verifier.verify(token);
//            true;
        } catch (Exception e) {
            log.error("Token Error:{}", e.getMessage());
        }
        return false;
    }
}
