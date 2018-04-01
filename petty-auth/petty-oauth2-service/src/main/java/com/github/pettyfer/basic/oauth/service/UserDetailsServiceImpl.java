package com.github.pettyfer.basic.oauth.service;

import com.github.pettyfer.basic.common.entity.User;
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
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(username);
        Preconditions.checkNotNull(user,"No user");
        return new UserDetailsImpl(user);
    }
}
