package com.example.oauth2test.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author lucky_yh
 * 2019/7/2 23:15
 */

//@Configuration
public class DataSourceConfiguration {

    /**
     * 默认就是hick连接池
     * @return
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }


}
