package com.example.demo.config.jwt;

import com.example.demo.config.auth.CustomUserDetails;
import com.example.demo.config.auth.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static org.springframework.util.StringUtils.hasText;

@Log
@Component
@RequiredArgsConstructor
public class JwtFilter extends GenericFilterBean {

    public static final String AUTHORIZATION = "Authorization";
    private final JwtProvider jwtProvider;
    private final CustomUserDetailsService customUserDetailsService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("do JWTFilter..");
        String token = getTokenFromRequest((HttpServletRequest) servletRequest);
        if (token != null && jwtProvider.validateToken(token)) {
            String userLogin = jwtProvider.getLoginFromToken(token);
            logger.debug("Try to find user with login: " + userLogin);
            CustomUserDetails customUserDetails = customUserDetailsService.loadUserByUsername(userLogin);
            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(customUserDetails,
                            null,
                            customUserDetails.getAuthorities()
                    );
            SecurityContextHolder.getContext().setAuthentication(auth);
            logger.debug("JWTFilter Successful");
        }
        logger.debug("JWT filter not complete");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String bearer = request.getHeader(AUTHORIZATION);
        if (hasText(bearer) && bearer.startsWith("Bearer ")) {
            return bearer.substring(7);
        }
        return null;
    }
}