package com.github.pettyfer.basic.common.feign.fallback;

import com.github.pettyfer.basic.common.feign.GroupInfoService;
import com.github.pettyfer.basic.common.model.GroupInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Petty
 */
@Service
public class GroupInfoServiceFallbackImpl implements GroupInfoService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<GroupInfo> findGroupInfoByUserId(String userId) {
        logger.error("调用{}异常:{}", "findGroupInfoByUserId", userId);
        return null;
    }
}
