package com.github.pettyfer.basic.basicinfoserver.controller;


import com.github.pettyfer.basic.common.model.basic.DeptInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 部门信息 前端控制器
 * </p>
 *
 * @author Pettyfer
 * @since 2018-02-28
 */
@RestController
@RequestMapping("/dept")
public class SystemDeptController {
    /**
     * 通过用户Id查询用户部门信息
     * @param userId 用户唯一标识符
     * @return 部门信息
     */
    @Cacheable(value = "basic:basic_dept",key = "'basic:basic_system_dept'.concat(':').concat(#userId)")
    @GetMapping("/findDeptInfoByUserId/{userId}")
    public DeptInfo findDeptInfoByUserId(@PathVariable String userId) {
        return new DeptInfo();
    }
}

