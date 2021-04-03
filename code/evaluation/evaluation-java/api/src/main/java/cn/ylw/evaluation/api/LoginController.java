package cn.ylw.evaluation.api;

import cn.hutool.json.JSONObject;
import cn.ylw.common.constant.ShiroConstants;
import cn.ylw.common.lang.ResponseResult;
import cn.ylw.common.util.JwtUtils;
import cn.ylw.evaluation.core.metadata.JwtMetadataConfig;
import cn.ylw.evaluation.entity.sys.Account;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ylw
 * @date: 2021年04月02日 13时29分
 * @description:
 */
@RestController
@RequestMapping("/")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {
    private final JwtMetadataConfig jwtMetadataConfig;
    @PostMapping("/login")
    public ResponseResult login(@RequestParam("username") String username, @RequestParam("password") String password) {
//        String realPassword = userService.getPassword(username);
//        if (realPassword == null) {
//            return Msg.fail().add("info", "用户名错误");
//        } else if (!realPassword.equals(password)) {
//            return Msg.fail().add("info", "密码错误");
//        } else {
//            return Msg.success().add("token", JWTUtil.createToken(username));
//        }
        Account account=new Account();
        account.setId("ssss");
        account.setName("手动阀发");
        account.setLoginAccount("双宿双飞");
        String token = JwtUtils.createToken(account.getId(), account.getLoginAccount(),jwtMetadataConfig.getExpire(),jwtMetadataConfig.getEncryptKey());
        return ResponseResult.success(new JSONObject().append(ShiroConstants.SHIRO_WEB_TOKEN_KEY, token));
    }
    @PostMapping("/test")
    @RequiresAuthentication
    public ResponseResult test() {
        Account account=new Account();
        account.setId("ssss");
        account.setName("手动阀发");
        account.setLoginAccount("双宿双飞");
        return ResponseResult.success("new JSONObject().append(ShiroConstants.SHIRO_WEB_TOKEN_KEY,jwtUtils.createToken(account))");
    }

}
