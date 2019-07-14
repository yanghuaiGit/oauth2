package com.example.server2.config;

import io.lettuce.core.ReadFrom;
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.provider.ClientDetails;

/**
 * @author lucky_yh
 * 2019/7/3 15:15
 */

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, ClientDetails> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, ClientDetails> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    /**
     * 优先读主节点
     */
    @Bean
    public LettuceClientConfigurationBuilderCustomizer customizer() {
        return builder -> builder.readFrom(ReadFrom.MASTER_PREFERRED);
    }
}
