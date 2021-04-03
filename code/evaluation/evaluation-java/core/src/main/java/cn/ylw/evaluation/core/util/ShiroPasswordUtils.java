package cn.ylw.evaluation.core.util;

import cn.ylw.common.constant.ShiroConstants;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Shiro密码凭证
 *
 * @author: ylw
 * @date: 2021年04月02日 14时28分
 * @description:
 */
public class ShiroPasswordUtils {

    /**
     * 对原文进行加密处理
     * @param password 原文密码
     * @param salt 盐
     * @return
     */
    public static String encrypt(String password, String salt) {
        return new SimpleHash(
                ShiroConstants.SHIRO_HASH_ALGORITHM,
                password,
                salt,
                ShiroConstants.SHIRO_HASH_ITERATIONS).toHex();
    }
}
