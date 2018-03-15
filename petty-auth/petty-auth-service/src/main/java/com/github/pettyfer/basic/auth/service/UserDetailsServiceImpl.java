package com.github.pettyfer.basic.auth.service;

import com.github.pettyfer.basic.auth.feign.UserService;
import com.github.pettyfer.basic.auth.utils.UserDetailsImpl;
import com.github.pettyfer.basic.common.entity.User;
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

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(username);
        return new UserDetailsImpl(user);
    }
}
