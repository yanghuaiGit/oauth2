package com.example.oauth2test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

/**
 * @author lucky_yh
 * 2019/7/3 15:13
 */
public class MyClientDetailsService extends JdbcClientDetailsService {


    @Autowired
    private RedisTemplate<String, ClientDetails> redisTemplate;

    public MyClientDetailsService(DataSource dataSource) {
        super(dataSource);
    }


    @Override
    public ClientDetails loadClientByClientId(String clientId) throws InvalidClientException {
        ClientDetails details = redisTemplate.opsForValue().get(clientId);
        if (details != null) {
            return details;
        }
        details = super.loadClientByClientId(clientId);
        if (details != null) {
            redisTemplate.opsForValue().set(clientId, details, 3, TimeUnit.HOURS);
        }
        return details;
    }


}
