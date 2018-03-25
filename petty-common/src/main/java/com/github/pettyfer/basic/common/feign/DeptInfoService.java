package com.github.pettyfer.basic.common.feign;

import com.github.pettyfer.basic.common.feign.fallback.DeptInfoServiceFallbackImpl;
import com.github.pettyfer.basic.common.model.DeptInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Petty
 */
@FeignClient(name = "petty-basic-info-service", fallback = DeptInfoServiceFallbackImpl.class)
public interface DeptInfoService {
    /**
     * 通过用户ID查询用户部门信息
     *
     * @param userId
     * @return 部门信息
     */
    @GetMapping("/dept/findDeptInfoByUserId/{userId}")
    DeptInfo findDeptInfoByUserId(@PathVariable("userId") String userId);
}
