package com.github.pettyfer.basic.common.feign;

import com.github.pettyfer.basic.common.feign.fallback.ResourceInfoServiceFallbackImpl;
import com.github.pettyfer.basic.common.model.basic.ResourceInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

/**
 * @author Petty
 * @date 2018/4/26
 */
@FeignClient(name = "petty-basic-info-service", fallback = ResourceInfoServiceFallbackImpl.class)
public interface ResourceInfoService {

    /**
     * 通过角色查询资源信息
     *
     * @param role 角色名称
     * @return 角色信息
     */
    @GetMapping("/resource/findResourceByRole/{role}")
    Set<ResourceInfo> findResourceByRole(@PathVariable("role") String role);
}
