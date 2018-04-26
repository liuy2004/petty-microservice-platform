package com.github.pettyfer.basic.common.feign;

import com.github.pettyfer.basic.common.feign.fallback.MenuInfoServiceFallbackImpl;
import com.github.pettyfer.basic.common.feign.fallback.RoleInfoServiceFallbackImpl;
import com.github.pettyfer.basic.common.model.basic.MenuInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

/**
 * @author Petty
 * @date 2018/4/26
 */
@FeignClient(name = "petty-basic-info-service", fallback = MenuInfoServiceFallbackImpl.class)
public interface MenuInfoService {

    /**
     * 通过角色查询菜单信息
     *
     * @param role 角色名称
     * @return 角色信息
     */
    @GetMapping("/menu/findMenuByRole/{role}")
    Set<MenuInfo> findMenuByRole(@PathVariable("role") String role);
}
