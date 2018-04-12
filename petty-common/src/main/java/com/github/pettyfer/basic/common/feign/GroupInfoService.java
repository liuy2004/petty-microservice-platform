package com.github.pettyfer.basic.common.feign;

import com.github.pettyfer.basic.common.feign.fallback.GroupInfoServiceFallbackImpl;
import com.github.pettyfer.basic.common.model.basic.GroupInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Petty
 */
@FeignClient(name = "petty-basic-info-service", fallback = GroupInfoServiceFallbackImpl.class)
public interface GroupInfoService {
    /**
     * 通过用户ID查询用户组信息
     *
     * @param userId
     * @return 用户组信息
     */
    @GetMapping("/group/findGroupInfoByUserId/{userId}")
    List<GroupInfo> findGroupInfoByUserId(@PathVariable("userId") String userId);
}
