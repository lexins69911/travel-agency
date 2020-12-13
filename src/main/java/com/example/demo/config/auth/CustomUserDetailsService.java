package com.example.demo.config.auth;

import com.example.demo.dao.domain.model.UserEntity;
import com.example.demo.service.domain.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public CustomUserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity byLogin = userService.findByLogin(s);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(byLogin);
    }

}
