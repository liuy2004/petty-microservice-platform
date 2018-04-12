package com.github.pettyfer.basic.common.feign.fallback;

import com.github.pettyfer.basic.common.feign.DeptInfoService;
import com.github.pettyfer.basic.common.model.basic.DeptInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Petty
 */
@Service
public class DeptInfoServiceFallbackImpl implements DeptInfoService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public DeptInfo findDeptInfoByUserId(String userId) {
        logger.error("调用{}异常:{}", "findDeptInfoByUserId", userId);
        return null;
    }
}
