package cn.ylw.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author: ylw
 * @date: 2021年04月01日 16时56分
 * @description:
 */
@Slf4j

public class JwtUtils {
    /**
     * 生成jwt token
     */
    public static String createToken(String accountId, String loginAccount,long expire,String encryptKey) {
        Date nowDate = new Date();
        //过期时间
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);
        return Jwts.builder()
                .setHeaderParam("type", "JWT")
                .setId(accountId)
                .setSubject(loginAccount)
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, encryptKey)
                .compact();
    }

    public static Claims getClaimByToken(String token,String encryptKey) {
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
    public static boolean isTokenExpired(String token,String encryptKey) {
        Claims claim = getClaimByToken(token,encryptKey);
        if (claim != null) {
            return claim.getExpiration().after(new Date());
        }
        return false;
    }

}
