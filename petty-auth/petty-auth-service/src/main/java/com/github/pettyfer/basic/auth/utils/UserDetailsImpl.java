package com.github.pettyfer.basic.auth.utils;

import com.github.pettyfer.basic.common.constant.CommonConstant;
import com.github.pettyfer.basic.common.constant.SecurityConstant;
import com.github.pettyfer.basic.common.entity.Role;
import com.github.pettyfer.basic.common.entity.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Petty
 * UserDetails接口实现
 */
@Data
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private Integer status;
    private List<Role> roleList = new ArrayList<>();

    public UserDetailsImpl(User user) {
        this.username = user.getUserName();
        this.password = user.getUserPwd();
        this.status = user.getStatus();
        roleList = user.getRoleList();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (Role role : roleList) {
            authorityList.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        //增加基础用户角色
        authorityList.add(new SimpleGrantedAuthority(SecurityConstant.BASE_ROLE));
        return authorityList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 用户是否锁定
     *
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return CommonConstant.STATUS_LOCK.equals(status) ? false : true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 用户是否有效
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        return CommonConstant.STATUS_NORMAL.equals(status) ? true : false;
    }
}
