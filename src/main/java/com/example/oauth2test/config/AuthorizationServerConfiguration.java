package com.example.oauth2test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.sql.DataSource;

/**
 * @author lucky_yh
 * 2019/7/2 21:51
 */

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    private DataSource dataSource;


    //这是 内存配置
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients
//                .inMemory()
//                .withClient("client")//客戶端id应该自动生成的
//                .secret(bCryptPasswordEncoder.encode("secret"))
//                .authorizedGrantTypes("authorization_code")
//                .scopes("app")
//                //  .scopes("read_userinfo", "read_contacts");
//                .redirectUris("http://127.0.0.1:8083/oauth2CallBack");
//
//    }

    /**
     * 配置token用jdbc
     *
     * @return
     */
//    @Bean
//    public TokenStore tokenStore() {
//        return new JdbcTokenStore(dataSource);
//    }

    /**
     * 配置client使用jdbc
     *
     * @return
     */
    @Bean
    public ClientDetailsService myClientDetailsService() {
        return new MyClientDetailsService(dataSource);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(myClientDetailsService());

    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();
        security.tokenKeyAccess("isAuthenticated()");
    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(jwtTokenStore()).accessTokenConverter(jwtAccessTokenConverter()).authorizationCodeServices(authorizationCodeServices());
    }

    @Bean
    public JwtTokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    /**
     * 签名服务，使用这个key进行校验
     *
     * @return
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("cjs");   //  Sets the JWT signing key
        return jwtAccessTokenConverter;
    }


    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        return new JdbcAuthorizationCodeServices(dataSource);
    }

}
