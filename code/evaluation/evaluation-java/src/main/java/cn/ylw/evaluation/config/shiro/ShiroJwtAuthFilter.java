package cn.ylw.evaluation.config.shiro;

import cn.ylw.evaluation.common.constant.ShiroConstants;
import cn.ylw.evaluation.common.util.IpUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

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
public class ShiroJwtAuthFilter extends BasicHttpAuthenticationFilter {
    /**
     * 如果带有 token，则对 token 进行检查，否则直接通过
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //判断请求的请求头是否带上 "token"
        if (isLoginAttempt(request, response)) {
            //如果存在，则进入 executeLogin 方法执行登入，检查 token 是否正确
            try {
                return executeLogin(request, response);
            } catch (Exception e) {
                //token 错误
                responseError(response, e.getMessage());
            }
        }
        //如果请求头不存在 token，则可能是执行登陆操作或者是游客状态访问，无需检查 token，直接返回 true
        return true;
    }

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        // 获取 token
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String jwtToken = servletRequest.getHeader(ShiroConstants.SHIRO_WEB_TOKEN_KEY);
        if (StringUtils.isBlank(jwtToken)) {
            return null;
        }
        return new JwtToken(jwtToken, IpUtils.getIpAddress(servletRequest));
    }
//
//    /**
//     * isAccessAllowed()方法返回false，会进入该方法，表示拒绝访问
//     */
//    @Override
//    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
//        String token = getAuthzHeader(servletRequest);
//        if (StringUtils.isBlank(token)) {
//            return true;
//        } else {
//            // 判断是否已过期
//            if (jwtUtils.isTokenExpired(token)) {
//                throw new ExpiredCredentialsException("登录状态已失效,请重新登录!");
//            }
//        }
//        // 执行自动登录
//        return executeLogin(servletRequest, servletResponse);
//    }


    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        return super.onLoginSuccess(token, subject, request, response);
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        return super.onLoginFailure(token, e, request, response);
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
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        return this.getAuthzHeader(request) != null;
    }

    @Override
    protected String getAuthzHeader(ServletRequest servletRequest) {
        return WebUtils.toHttp(servletRequest).getHeader(ShiroConstants.SHIRO_WEB_TOKEN_KEY);
    }

    /**
     * 将非法请求跳转到 /unauthorized/**
     */
    private void responseError(ServletResponse response, String message) {
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            //设置编码，否则中文字符在重定向时会变为空字符串
            message = URLEncoder.encode(message, "UTF-8");
            httpServletResponse.sendRedirect("/unauthorized/" + message);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
