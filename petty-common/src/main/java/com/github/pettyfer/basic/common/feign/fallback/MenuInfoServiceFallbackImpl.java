package com.github.pettyfer.basic.common.feign.fallback;

import com.github.pettyfer.basic.common.feign.MenuInfoService;
import com.github.pettyfer.basic.common.model.basic.MenuInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author Petty
 * @date 2018/4/26
 */
@Service
public class MenuInfoServiceFallbackImpl implements MenuInfoService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 通过角色查询菜单信息
     *
     * @param role 角色名称
     * @return 角色信息
     */
    @Override
    public Set<MenuInfo> findMenuByRole(String role) {
        logger.error("调用{}异常:{}", "findMenuByRole", role);
        return null;
    }
}
