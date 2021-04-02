package cn.ylw.evaluation.config.shiro;

import cn.ylw.evaluation.entity.sys.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: ylw
 * @date: 2021年04月01日 16时56分
 * @description:
 */
@Slf4j
@Component
@Data
@ConfigurationProperties(prefix = "shiro.jwt")
public class JwtUtils {
    private String encryptKey;
    private long expire;

    /**
     * 生成jwt token
     */
    public String createToken(Account account) {
        Date nowDate = new Date();
        //过期时间
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);
        return Jwts.builder()
                .setHeaderParam("type", "JWT")
                .setId(account.getId())
                .setSubject(account.getLoginAccount())
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, encryptKey)
                .compact();
    }

    public Claims getClaimByToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(encryptKey)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.warn("validate is token error ", e);
            return null;
        }
    }

    /**
     * token是否过期
     *
     * @return true：过期
     */
    public boolean isTokenExpired(String token) {
        Claims claim = getClaimByToken(token);
        if (claim != null) {
            return claim.getExpiration().before(new Date());
        }
        return false;
    }

}
