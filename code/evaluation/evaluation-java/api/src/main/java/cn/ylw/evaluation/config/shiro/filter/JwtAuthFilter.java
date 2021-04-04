package cn.ylw.evaluation.config.shiro.filter;

import cn.ylw.common.constant.ShiroConstants;
import cn.ylw.evaluation.api.util.IpUtils;
import cn.ylw.evaluation.config.shiro.token.JwtToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Jwt过滤器
 *
 * @author: ylw
 * @date: 2021年04月01日 16时30分
 * @description:
 */
@Slf4j
public class JwtAuthFilter extends AuthenticatingFilter {

    /**
     * 如果带有 token，则对 token 进行检查，否则直接通过
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return super.isAccessAllowed(request, response, mappedValue);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
//        try {
        //判断请求的请求头是否带上 "token"
        if (isLoginAttempt(request, response)) {
            return executeLogin(request, response);
        }
//        } catch (Exception e) {
//            log.error("Shiro error", e);
//            responseError(response);
//        }
        //如果请求头不存在 token，则可能是执行登陆操作或者是游客状态访问，无需检查 token，直接返回 true
        return true;
    }

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        // 获取 token
        HttpServletRequest servletRequest = WebUtils.toHttp(request);
        String jwtToken = servletRequest.getHeader(ShiroConstants.SHIRO_WEB_TOKEN_KEY);
        if (StringUtils.isBlank(jwtToken)) {
            return null;
        }
        return new JwtToken(jwtToken, IpUtils.getIpAddress(servletRequest));
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        log.debug(" ===onLoginSuccess ");
        return super.onLoginSuccess(token, subject, request, response);
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        try {
//            //处理登录失败的异常
//            Throwable throwable = e.getCause() == null ? e : e.getCause();
//
//            httpResponse.getWriter().print(ResponseResult.fail(throwable.getMessage()));
//        } catch (IOException e1) {
//        }
//       return false;
//        throw new ShiroException(e);
        return false;
    }

    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个OPTIONS请求，这里我们给OPTIONS请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(org.springframework.http.HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }

    /**
     * 判断用户是否想要登入。
     * 检测 header 里面是否包含 token 字段
     */
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        return this.getAuthzHeader(request) != null;
    }

    protected String getAuthzHeader(ServletRequest servletRequest) {
        return WebUtils.toHttp(servletRequest).getHeader(ShiroConstants.SHIRO_WEB_TOKEN_KEY);
    }

    /**
     * 将Shiro异常信息重定向到/shiroException/进行异常抛出
     */
    private void responseError(ServletResponse response) {
//        try {
//            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
////            //设置编码，否则中文字符在重定向时会变为空字符串
////            message = URLEncoder.encode(message, "UTF-8");
//            httpServletResponse.sendRedirect("/shiroException/");
//        } catch (IOException e) {
//            log.error(e.getMessage(), e);
//        }
    }
}
