package cn.ylw.evaluation.config.shiro;

import lombok.RequiredArgsConstructor;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Shiro权限配置
 *
 * @author: ylw
 * @date: 2021年04月01日 16时28分
 * @description:
 */
@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShiroConfig {
    private final ShiroJwtAuthFilter shiroJwtFilter;

    @Bean
    public SessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        // 去掉shiro登录时url里的JSESSIONID
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }
}
