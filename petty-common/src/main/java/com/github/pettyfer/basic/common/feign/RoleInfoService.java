package com.github.pettyfer.basic.common.feign;

import com.github.pettyfer.basic.common.feign.fallback.RoleInfoServiceFallbackImpl;
import com.github.pettyfer.basic.common.model.basic.RoleInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Petty
 */
@FeignClient(name = "petty-basic-info-service", fallback = RoleInfoServiceFallbackImpl.class)
public interface RoleInfoService {
    /**
     * 通过用户ID查询用户详细信息
     *
     * @param userId
     * @return 角色信息
     */
    @GetMapping("/role/findRoleInfoByUserId/{userId}")
    List<RoleInfo> findRoleInfoByUserId(@PathVariable("userId") String userId);
}
