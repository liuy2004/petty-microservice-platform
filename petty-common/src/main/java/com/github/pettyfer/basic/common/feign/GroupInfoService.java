package com.github.pettyfer.basic.common.feign;

import com.github.pettyfer.basic.common.feign.fallback.GroupInfoServiceFallbackImpl;
import com.github.pettyfer.basic.common.model.GroupInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "petty-basic-info-service", fallback = GroupInfoServiceFallbackImpl.class)
public interface GroupInfoService {
    /**
     * 通过用户ID查询用户组信息
     * @param userId
     * @return 用户组信息
     */
    @GetMapping("/role/findGroupInfoByUserId/{userId}")
    GroupInfo findGroupInfoByUserId(@PathVariable("userId") String userId);
}
