package com.github.pettyfer.basic.auth.utils;

import com.github.pettyfer.basic.common.constant.CommonConstant;
import com.github.pettyfer.basic.common.constant.SecurityConstants;
import com.github.pettyfer.basic.common.vo.RoleVo;
import com.github.pettyfer.basic.common.vo.UserVo;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Petty
 */
@Data
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private Integer status;
    private List<RoleVo> roleList = new ArrayList<>();

    public UserDetailsImpl(UserVo userVo) {
        this.username = userVo.getUserName();
        this.password = userVo.getUserPwd();
        this.status = userVo.getStatus();
        roleList = userVo.getRoleVoList();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (RoleVo role : roleList) {
            authorityList.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        authorityList.add(new SimpleGrantedAuthority(SecurityConstants.BASE_ROLE));
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

    @Override
    public boolean isAccountNonLocked() {
        return CommonConstant.STATUS_LOCK.equals(status) ? false : true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return CommonConstant.STATUS_NORMAL.equals(status) ? true : false;
    }
}
