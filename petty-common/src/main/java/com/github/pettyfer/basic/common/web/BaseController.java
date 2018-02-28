package com.github.pettyfer.basic.common.web;

import com.github.pettyfer.basic.common.utils.UserUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 基础Controller
 *
 * @author Petty
 */
public class BaseController {
    @Autowired
    private HttpServletRequest request;
    protected org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 获取Jwt中的角色名
     *
     * @return 角色列表
     */
    public List<String> getRole() {
        return UserUtils.getRole(request);
    }
}
