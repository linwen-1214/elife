package cn.ylw.evaluation.config.shiro.filter;

import cn.ylw.common.constant.ShiroConstants;
import cn.ylw.common.lang.ResponseResult;
import cn.ylw.evaluation.api.util.IpUtils;
import cn.ylw.evaluation.config.shiro.token.JwtToken;
import cn.ylw.evaluation.core.exception.LoginException;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Jwt过滤器
 *
 * @author: ylw
 * @date: 2021年04月01日 16时30分
 * @description:
 */
@Slf4j
public class JwtAuthFilter extends BasicHttpAuthenticationFilter {

    /**
     * 如果带有 token，则对 token 进行检查，否则直接通过
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return super.isAccessAllowed(request, response, mappedValue);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        //判断请求的请求头是否带上 "token"
        if (isLoginAttempt(request, response)) {
            return executeLogin(request, response);
        }

        //如果请求头不存在 token，则可能是执行登陆操作或者是游客状态访问，无需检查 token，直接返回 true
        return true;
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        AuthenticationToken token = this.createToken(request, response);
        if (token == null) {
            String msg = "createToken method implementation returned null. A valid non-null AuthenticationToken must be created in order to execute a login attempt.";
            throw new IllegalStateException(msg);
        } else {
            try {
                Subject subject = this.getSubject(request, response);
                subject.login(token);
                return this.onLoginSuccess(token, subject, request, response);
            } catch (AuthenticationException e) {
                log.error("Shiro error", e);
                responseError(response);
                this.onLoginFailure(token, e, request, response);
                return false;
            }
        }
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
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        return this.getAuthzHeader(request) != null;
    }

    @Override
    protected String getAuthzHeader(ServletRequest servletRequest) {
        return WebUtils.toHttp(servletRequest).getHeader(ShiroConstants.SHIRO_WEB_TOKEN_KEY);
    }

    /**
     * 将Shiro异常信息重定向到/shiroException/进行异常抛出
     */
    private void responseError(ServletResponse response) {
        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        try (PrintWriter out = httpServletResponse.getWriter()) {
            LoginException shiroLoginError = LoginException.SHIRO_LOGIN_ERROR;
            out.append(JSONObject.toJSONString(ResponseResult.fail(shiroLoginError.getStatus(), shiroLoginError.getCode(), shiroLoginError.getExMessage())));
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }
}
