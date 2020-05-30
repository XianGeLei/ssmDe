package com.kaptcha;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import org.springframework.security.core.AuthenticationException;

/**
 * Kaptcha 拦截器
 *
 * @author zzg
 **/




public class KaptchaFilter extends AbstractAuthenticationProcessingFilter {

    // SESSION 关于 验证码
    private static final String VRIFYCODE ="vrifyCode";

    // 拦截请求地址
    private String servletPath;

    public KaptchaFilter(String servletPath, String failureUrl) {
        super(servletPath);
        this.servletPath = servletPath;
        setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler(failureUrl));
    }



    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if ("POST".equalsIgnoreCase(req.getMethod()) && servletPath.equals(req.getServletPath())) {
            String expect = (String) req.getSession().getAttribute(VRIFYCODE);
            if (expect != null && !expect.equalsIgnoreCase(req.getParameter(VRIFYCODE))) {
                unsuccessfulAuthentication(req, res, new InsufficientAuthenticationException("输入的验证码不正确"));
                return;
            }
        }
        chain.doFilter(req, res);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        // TODO Auto-generated method stub
        return null;
    }

}
