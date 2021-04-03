package cn.ylw.evaluation.core.metadata;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: ylw
 * @date: 2021年04月03日 18时39分
 * @description:
 */
@Component
@Data
@ConfigurationProperties(prefix = "shiro.jwt")
public class JwtMetadataConfig {
    private String encryptKey;
    private long expire;
}
