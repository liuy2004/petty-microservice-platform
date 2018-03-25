package com.github.pettyfer.basic.gateway.config;

import com.github.pettyfer.basic.common.constant.CommonConstant;
import com.github.pettyfer.basic.common.utils.UserUtils;
import com.github.pettyfer.basic.gateway.ratelimit.config.RateLimitKeyGenerator;
import com.github.pettyfer.basic.gateway.ratelimit.config.properties.RateLimitProperties;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.Route;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * @author Petty
 */
public class GateRateLimitKeyGenerator implements RateLimitKeyGenerator {

    private static final String ANONYMOUS_USER = "ANONYMOUS";

    /**
     * 获取客户端IP
     *
     * @param request
     * @return
     */
    public static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(ip) && !CommonConstant.UN_KNOWN_CLIENT_IP.equalsIgnoreCase(ip)) {
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotEmpty(ip) && !CommonConstant.UN_KNOWN_CLIENT_IP.equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }

    /**
     * 获取设备类型
     *
     * @param request
     * @return
     */
    public static String getClientInfo(HttpServletRequest request) {
        String agent = request.getHeader("User-Agent");
        StringTokenizer st = new StringTokenizer(agent, ";");
        st.nextToken();
        String clientType = st.nextToken();
        return clientType;
    }

    @Override
    public String key(HttpServletRequest request, Route route, RateLimitProperties.Policy policy) {
        final List<RateLimitProperties.Policy.Type> types = policy.getType();
        final StringJoiner joiner = new StringJoiner(":");
        // 获取用户名称
        String username = UserUtils.getUserName(request);
        joiner.add(getClientIp(request));
        joiner.add(getClientInfo(request));
        if (route != null) {
            joiner.add(route.getId());
        }
        if (!types.isEmpty()) {
            if (types.contains(RateLimitProperties.Policy.Type.URL) && route != null) {
                joiner.add(route.getPath());
            }
            if (types.contains(RateLimitProperties.Policy.Type.USER) && StringUtils.isBlank(username)) {
                joiner.add(ANONYMOUS_USER);
            } else {
                joiner.add(username);
            }
        }
        return joiner.toString();
    }
}
