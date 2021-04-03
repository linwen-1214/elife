package cn.ylw.evaluation.config.shiro;

import cn.ylw.common.constant.ShiroConstants;
import cn.ylw.evaluation.config.shiro.realm.AccountRealm;
import cn.ylw.evaluation.config.shiro.filter.ShiroJwtAuthFilter;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SessionStorageEvaluator;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro权限配置
 *
 * @author: ylw
 * @date: 2021年04月01日 16时28分
 * @description:
 */
@Configuration
public class ShiroConfig {

    @Bean
    public SessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        // 去掉shiro登录时url里的JSESSIONID
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }
    /**
     * Shiro 加密凭证设置
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        // 设置哈希算法名称
        matcher.setHashAlgorithmName(ShiroConstants.SHIRO_HASH_ALGORITHM);
        // 设置哈希迭代次数
        matcher.setHashIterations(ShiroConstants.SHIRO_HASH_ITERATIONS);
        // 设置存储凭证十六进制编码
        matcher.setStoredCredentialsHexEncoded(true);
        return matcher;
    }

    @Bean
    public AccountRealm accountRealm(){
        AccountRealm accountRealm=new AccountRealm();
        accountRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return accountRealm;
    }

    @Bean
    public DefaultWebSecurityManager securityManager(AccountRealm accountRealm, SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(accountRealm);
        securityManager.setSessionManager(sessionManager);
        /*
         * 关闭shiro自带的session，详情见文档
         */
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        subjectDAO.setSessionStorageEvaluator(sessionStorageEvaluator());
        securityManager.setSubjectDAO(subjectDAO);
        return securityManager;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        Map<String, String> filterMap = new LinkedHashMap<>();
        // 主要通过注解方式校验权限
        filterMap.put("/**", "jwt");
        chainDefinition.addPathDefinitions(filterMap);
        return chainDefinition;
    }

    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager, ShiroFilterChainDefinition shiroFilterChainDefinition) {
        // 不再通过编码形式拦截Controller访问路径，
        // 而是所有的路由都需要经过JwtFilter这个过滤器，
        // 然后判断请求头中是否含有jwt的信息，有就登录，没有就跳过。
        // 跳过之后，有Controller中的shiro注解进行再次拦截，
        // 比如@RequiresAuthentication，这样控制权限访问
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        Map<String, Filter> filters = new HashMap<>();
        filters.put("jwt", getShiroJwtFilter());
        shiroFilter.setFilters(filters);
        Map<String, String> filterMap = shiroFilterChainDefinition.getFilterChainMap();
        // 所有请求通过我们自己的JWT Filter
        filterMap.put("/**", "jwt");
        // 放行不需要权限认证的接口
        //放行登录接口和其他不需要权限的接口
        filterMap.put("/login", "anon");
        filterMap.put("/unauthorized/**", "anon");
        shiroFilter.setFilterChainDefinitionMap(filterMap);
        return shiroFilter;
    }

    @Bean
    public ShiroJwtAuthFilter getShiroJwtFilter(){
        return new ShiroJwtAuthFilter();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        // 开启注解代理（默认好像已经开启，可以不要）
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

//    @Bean
//    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
//        return creator;
//    }

    /**
     * 禁用session, 不保存用户登录状态。保证每次请求都重新认证
     * 我们需要设置为false，这样用户就不再能通过session方式登录shiro。后面将采用jwt凭证登录。
     */
    @Bean
    protected SessionStorageEvaluator sessionStorageEvaluator() {
        DefaultSessionStorageEvaluator sessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        sessionStorageEvaluator.setSessionStorageEnabled(false);
        return sessionStorageEvaluator;
    }
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
}
