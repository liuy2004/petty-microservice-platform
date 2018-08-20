package com.github.pettyfer.basic.oauth.service;

import com.github.pettyfer.basic.common.feign.UserInfoService;
import com.github.pettyfer.basic.common.model.auth.User;
import com.github.pettyfer.basic.oauth.feign.UserService;
import com.github.pettyfer.basic.oauth.utils.UserDetailsImpl;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Petty
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserInfoService userInfoService;

    @Autowired
    public UserDetailsServiceImpl(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userInfoService.findUserByUsername(username);
        Preconditions.checkNotNull(user,"No user");
        return new UserDetailsImpl(user);
    }
}
