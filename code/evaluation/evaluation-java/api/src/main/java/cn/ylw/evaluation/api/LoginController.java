package cn.ylw.evaluation.api;

import cn.ylw.common.constant.JwtConstants;
import cn.ylw.common.constant.ShiroConstants;
import cn.ylw.common.lang.ResponseResult;
import cn.ylw.common.util.JwtUtils;
import cn.ylw.evaluation.core.exception.LoginException;
import cn.ylw.evaluation.core.exception.OperationException;
import cn.ylw.evaluation.entity.sys.Account;
import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @author: ylw
 * @date: 2021年04月02日 13时29分
 * @description:
 */
@RestController
@RequestMapping("/")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {

    @PostMapping("/login")
    public ResponseResult login(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                HttpServletResponse response) {

        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(username, password));
            //Shiro认证通过后会将Account信息放到subject内，生成token并返回
            Account account = (Account) subject.getPrincipal();
            String token = JwtUtils.createToken(account.getId(), account.getLoginAccount(), JwtConstants.EXPIRE, JwtConstants.KEY);
            JSONObject json = new JSONObject();
            json.put("account", account);
            json.put(ShiroConstants.SHIRO_WEB_TOKEN_KEY, token);
            response.setHeader(ShiroConstants.SHIRO_WEB_TOKEN_KEY, token);
            return ResponseResult.success(json);
        } catch (UnknownAccountException e) {
            throw new OperationException(LoginException.NOT_EXISTS_ACCOUNT, e);
        } catch (LockedAccountException e) {
            throw new OperationException(LoginException.NOT_ENABLE_ACCOUNT, e);
        } catch (DisabledAccountException e) {
            throw new OperationException(LoginException.NOT_ENABLE_ACCOUNT_ORGANIZATION);
        } catch (AuthenticationException e) {
            throw new OperationException(LoginException.NOT_EQUALS_PASSWORD);
        }
    }
    @GetMapping(value = "/logout")
    public ResponseResult logout() {
        Subject subject = SecurityUtils.getSubject();
        if(subject.getPrincipals() != null) {

        }
        SecurityUtils.getSubject().logout();
        return ResponseResult.success();
    }

    @PostMapping("/test")
    @RequiresAuthentication
    public ResponseResult test() {
        Account account = new Account();
        account.setId("ssss");
        account.setName("手动阀发");
        account.setLoginAccount("双宿双飞");
        return ResponseResult.success("new JSONObject().append(ShiroConstants.SHIRO_WEB_TOKEN_KEY,jwtUtils.createToken(account))");
    }

}
