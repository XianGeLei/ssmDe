package com.securitys;


import com.kaptcha.KaptchaFilter;
import com.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 设置不拦截规则
        web.ignoring().antMatchers("/login.jsp","/pages/user/useradd.jsp",
        "/test2.html","/favicon.ico",
                "/css/**",
                "/plugins/**",
                "/img/**","/defaultKaptcha");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * authorizeRequests()  配置路径拦截，表明路径访问所对应的权限，角色，认证信息。
         * formLogin()          对应表单认证相关的配置
         * logout()             对应了注销相关的配置
         * httpBasic()          可以配置basic登录
         * etc
         * sessionManagement()  session管理
         */
        http.csrf().disable().authorizeRequests()
                .antMatchers("/resources/**", "/login.jsp","/login", "/test2.html","/defaultKaptcha","/pages/user/useradd.jsp").permitAll()
             .antMatchers("/**").hasAnyRole("USER","ADMIN","SUPER_ADMIN")
                //.antMatchers("/pages/admin/**").hasRole("USER")
                //.antMatchers("/pages/dangan/**").hasRole("USER")
                /*.access("hasRole('USER') and hasRole('ADMIN')")*/

                /*
                anyRequest：任何的请求
                authenticated：认证
                */
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login").loginPage("/login.jsp")
                .defaultSuccessUrl("/pages/adminindex.jsp")
                .failureForwardUrl("/login.jsp")
                .failureUrl("/login.jsp")
                .permitAll()
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login.jsp");

        //在认证用户名之前认证验证码，如果验证码错误，将不执行用户名和密码的认证
             http.
                addFilterBefore(new KaptchaFilter("/login", "/login.jsp"), UsernamePasswordAuthenticationFilter.class);

        //记住密码
                /*.formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .successForwardUrl("main.html")
                .failureForwardUrl("test2.html")
                .loginPage("login.html")
                .loginProcessingUrl("/login")
                .permitAll()
                .and()
                *//*
                // 定义登录认证失败后执行的操作
                .failureHandler(this.authenticationFailureHandler())
                // 定义登录认证曾工后执行的操作
                .successHandler(this.authenticationSuccessHandler());
                *//*
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("login.html")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
                .httpBasic()
                .disable()
                // 禁用 CSRF
                .csrf()
                .disable()
                // session管理*/
            /*    .sessionManagement()
                .sessionFixation().none().maximumSessions(1);*/
        http.headers().frameOptions().sameOrigin();
    }

    /**
     * 登录认证配置
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(this.bCryptPasswordEncoder());
     /*   auth.inMemoryAuthentication()
                .withUser("lei").password("123456").roles("USER");*/
               /* .and()
                .passwordEncoder(bCryptPasswordEncoder());//配置BCrypt加密*/
    }


    @Bean(name = "bCryptPasswordEncoder")
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
