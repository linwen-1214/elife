package cn.ylw.evaluation.config.shiro.token;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author: ylw
 * @date: 2021年04月01日 16时38分
 * @description:
 */
public class JwtToken implements AuthenticationToken {
    private String token;
    private String host;

    public JwtToken(String token) {
        this(token,null);
    }

    public JwtToken(String token, String host) {
        this.token = token;
        this.host = host;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }


    public String getToken() {
        return token;
    }

    public String getHost() {
        return host;
    }

    @Override
    public String toString() {
        return token + ":" + host;
    }
}
