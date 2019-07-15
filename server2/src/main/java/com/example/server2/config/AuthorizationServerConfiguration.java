package com.example.server2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
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
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * @author lucky_yh
 * 2019/7/2 21:51
 */

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

//    private final TokenStore tokenStore;
//    private final ClientDetailsService clientDetailsService;
//    private final AuthorizationCodeServices authorizationCodeServices;
//
//    @Autowired
//    public AuthorizationServerConfiguration(TokenStore tokenStore, ClientDetailsService clientDetailsService, AuthorizationCodeServices authorizationCodeServices) {
//        this.tokenStore = tokenStore;
//        this.clientDetailsService = clientDetailsService;
//        this.authorizationCodeServices = authorizationCodeServices;
//    }

    @Autowired
    private DataSource dataSource;

    /**
     * 配置token用jdbc
     *
     * @return
     */
    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    /**
     * 配置client使用jdbc
     *
     * @return
     */
    @Bean
    public ClientDetailsService myClientDetailsService() {
        return new MyClientDetailsService(dataSource);
    }


    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        return new JdbcAuthorizationCodeServices(dataSource);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(myClientDetailsService());

    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();
        //访问/oauth/check_token 需要client验证 主要是为了避免资源服务器通过remoteservice解析accesstoken时，访问/oauth/check_token会提示没有权限
        security.tokenKeyAccess("isAuthenticated()");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore()).authorizationCodeServices(authorizationCodeServices());
        //这是授权页面
        //        .pathMapping("/oauth/confirm_access", "/token/confirm_access")
    }


}
