package com.github.pettyfer.basic.common.feign.fallback;

import com.github.pettyfer.basic.common.feign.RoleInfoService;
import com.github.pettyfer.basic.common.model.basic.RoleInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Petty
 */
@Service
public class RoleInfoServiceFallbackImpl implements RoleInfoService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<RoleInfo> findRoleInfoByUserId(String userId) {
        logger.error("调用{}异常:{}", "findRoleInfoByUserId", userId);
        return null;
    }
}
