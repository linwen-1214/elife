package cn.ylw.evaluation.api;

import cn.ylw.evaluation.core.exception.LoginException;
import cn.ylw.evaluation.core.exception.OperationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ylw
 * @date: 2021年04月04日 15时47分
 * @description:
 */
@RestController
@RequestMapping("/shiroException")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShiroExceptionController {
    @RequestMapping("/")
    public void error() {
        throw new OperationException(LoginException.SHIRO_LOGIN_ERROR);
    }
}
