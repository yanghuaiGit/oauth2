package com.example.server2.config;

import com.example.server2.constant.FromLoginConstant;
import com.example.server2.handler.MyAuthenticationFailHandler;
import com.example.server2.handler.MyAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author lucky_yh
 * 2019/7/2 22:22
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private MyAuthenticationFailHandler myAuthenticationFailHandler;

    /**
     * 创建一个加密算法
     * 2.0版本的oauth2强制必须要有一个
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService();
    }

    /**
     * 创建用户管理 内存管理
     * @param auth
     * @throws Exception
     */
    //改为RBAC的用户权限模型
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password(bCryptPasswordEncoder().encode("123456")).roles("ADMIN"."ROOT")
//                .and()
//                .withUser("root").password(bCryptPasswordEncoder().encode("123456")).roles("ROOT");
//    }

    /**
     * 创建用户管理 数据库管理
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //忽略/oauth/check_token授权
        web.ignoring().antMatchers("/oauth/check_token", "/assets/**", "/css/**", "/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
////                .formLogin()
////                .loginPage("/login")
//                //会跳转到百度页面
//              //  .loginPage("https://www.baidu.com/")
//              //  .and()
//                .authorizeRequests()
//                //login GET请求是放过的  permitAll无条件放过
//                .antMatchers(HttpMethod.GET, "/login").permitAll()
//                .antMatchers("/api/**").authenticated()
//                //.antMatchers("/api/**").hasRole("ROOT")
//                //access里是EL表达式  为真 就放过
//                // .antMatchers("/api/**").access("hasAuthority('ROLE_ROOT') and hasIpAddress('192.168.1.62')")
//                .anyRequest()
//                //authenticated 允许认证过的访问
//                .authenticated()
//                .and().csrf().disable().cors()
////                .and()
////                //可以设置token存储的位置 jdbc还是memory 或者是自己自定义
////                .rememberMe().tokenValiditySeconds(2419200).key("splitttrkey")
//                .and()
//                .logout().logoutSuccessUrl("/logout").logoutSuccessUrl("/");
////                .and()
////                .requiresChannel()
////                .antMatchers("/https/**").requiresSecure();//请求必须是HTTPS

        http.formLogin().loginPage("http://localhost:8080/#/login")
                .loginProcessingUrl("/auth/authorize")
                .successHandler(myAuthenticationSuccessHandler).failureHandler(myAuthenticationFailHandler)
                .and().authorizeRequests()

                .antMatchers("/login", "/oauth/**", "/auth/authorize","http://localhost:8080/#/login")
                .permitAll()
                .antMatchers("/api/**").authenticated()
                .and().csrf().disable();
    }
}
