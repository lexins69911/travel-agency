package com.example.demo.config.handler;

import com.example.demo.config.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log
@Component
@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtProvider jwtProvider;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Authentication authentication) throws IOException, ServletException {
        log.info("Start do Authentication Success Handler");
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        httpServletResponse.addHeader("Authorization", jwtProvider.generateToken(authentication.getName()));
//        httpServletResponse.getWriter().write(jwtProvider.generateToken(authentication.getName()));
//        httpServletResponse.getWriter().flush();
//        httpServletResponse.getWriter().close();
    }
}
