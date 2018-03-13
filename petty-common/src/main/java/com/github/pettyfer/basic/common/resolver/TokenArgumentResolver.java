package com.github.pettyfer.basic.common.resolver;

import com.github.pettyfer.basic.common.constant.SecurityConstant;
import com.github.pettyfer.basic.common.dto.RoleDto;
import com.github.pettyfer.basic.common.dto.UserDto;
import com.github.pettyfer.basic.common.exception.auth.TokenErrorException;
import com.github.pettyfer.basic.common.utils.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Petty
 * @date 2018年2月27日
 * Token转化UserVo
 */
@Slf4j
@Configuration
public class TokenArgumentResolver implements HandlerMethodArgumentResolver {
    private CacheManager cacheManager;

    /**
     * 更绝Token解析用户信息并存入Redis
     *
     * @param request
     * @param token
     * @return
     */
    private UserDto generatorByToken(HttpServletRequest request, String token) {
        String username = UserUtils.getUserName(request);
        List<String> roles = UserUtils.getRole(request);
        log.info("Auth-Token-User:{}-Roles:{}", username, roles);
        UserDto userDto = new UserDto();
        userDto.setUserName(username);
        List<RoleDto> sysRoleList = new ArrayList<>();
        roles.stream().forEach(role -> {
            RoleDto sysRole = new RoleDto();
            sysRole.setRoleName(role);
            sysRoleList.add(sysRole);
        });
        userDto.setRoleDtoList(sysRoleList);
        cacheManager.getCache(SecurityConstant.TOKEN_USER_DETAIL).put(token, userDto);
        return userDto;
    }

    public TokenArgumentResolver(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    /**
     * 筛选参数
     *
     * @param methodParameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(UserDto.class);
    }

    /**
     * 从缓存中获取用户信息，如果缓存中不存在该用户信息则从Token中获取
     *
     * @param methodParameter
     * @param modelAndViewContainer
     * @param nativeWebRequest
     * @param webDataBinderFactory
     * @return
     * @throws Exception
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        String token = UserUtils.getToken(request);
        if (StringUtils.isBlank(token)) {
            log.error("resolveArgument error token is empty");
            throw new TokenErrorException("invalid token");
        }
        Optional<UserDto> optional = Optional.ofNullable(cacheManager.getCache(SecurityConstant.TOKEN_USER_DETAIL).get(token, UserDto.class));
        if (optional.isPresent()) {
            log.info("return cache user dto,token :{}", token);
            return optional.get();
        }
        return optional.orElseGet(() -> generatorByToken(request, token));
    }

}
