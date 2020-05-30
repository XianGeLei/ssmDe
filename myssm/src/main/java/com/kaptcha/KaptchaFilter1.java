/*
package com.swust.kaptcha;

import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class KaptchaFilter1 extends UsernamePasswordAuthenticationFilter {

    // SESSION 关于 验证码
    private static final String VRIFYCODE ="vrifyCode";
   */
/*  @Override
   public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        HttpServletRequest req =  request;
        HttpServletResponse res =  response;

        String expect = (String) req.getSession().getAttribute(VRIFYCODE);
        if (expect != null && !expect.equalsIgnoreCase(req.getParameter(VRIFYCODE))) {
            try {
                unsuccessfulAuthentication(req, res, new InsufficientAuthenticationException("输入的验证码不正确"));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }

        }

        String requestCaptcha = request.getParameter(this.getCaptchaFieldName());
        String genCaptcha = (String)request.getSession().getAttribute("code");

        logger.info("开始校验验证码，生成的验证码为："+genCaptcha+" ，输入的验证码为："+requestCaptcha);

        if( !genCaptcha.equals(requestCaptcha)){
            throw new CaptchaException(
                    this.messageSource.getMessage("AbstractUserDetailsAuthenticationProvider.badCaptcha",null,"Default",null));
        }
        return super.attemptAuthentication(request, response);
    }*//*

}
*/
