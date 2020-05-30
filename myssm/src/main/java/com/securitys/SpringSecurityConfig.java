/*
package com.swust.securitys;

import com.alibaba.druid.pool.DruidDataSource;
import com.swust.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;

*/
/**
 * Security的配置类
 *
 * @author Braycep
 * @date 2019/3/6 14:09
 *//*

@Configuration
@EnableWebSecurity(debug = false)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    //自定义的身份认证处理类,实现UserDetailsService接口
    @Resource(name = "userServiceImpl")
    private UserDetailsService userServiceImpl;



    //security自带的密码加密类
    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //用于对记住我这个功能生成token
*/
/*    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }*//*


    //配置访问
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //放行
                .antMatchers("/plugins/**", "/css/**", "/img/**", "/js/**", "login.html").permitAll()
                //角色 SU 可以访问"/html/**"
                //.antMatchers("/html/**").hasRole("SU")
                //已经认证过的就可以访问
                .anyRequest().authenticated()
                .and()
                .headers()
                //设置页面frame分区的策略
                .frameOptions().sameOrigin()
                .and()
                //使用security的/login登录验证, loginProcessingUrl的值就是表单提交的地址
                .formLogin().loginProcessingUrl("/login").loginPage("/login.html")
                .defaultSuccessUrl("/index.html")
                .failureForwardUrl("/login.html?failed")
                .failureUrl("/login.html?failed")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login.html");
                //记住密码


        // 加http.csrf().disable()是为了防止报这个错Whitelabel Error Page
        //This application has no explicit mapping for /error, so you are seeing this as a fallback.
        http.csrf().disable();
    }

    //设置密码加密的方式
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceImpl).passwordEncoder(getBCryptPasswordEncoder());
    }
}*/
