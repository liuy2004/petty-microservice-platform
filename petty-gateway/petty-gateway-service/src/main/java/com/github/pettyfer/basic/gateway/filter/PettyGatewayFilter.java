package com.github.pettyfer.basic.gateway.filter;

import com.github.pettyfer.basic.common.constant.CommonConstant;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义ZuulFilter
 * @author Petty
 */
@Slf4j
@Component
public class PettyGatewayFilter extends ZuulFilter{
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 时候执行过滤器
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getHeader(CommonConstant.REQUEST_HEADER);

        //只配置Token转发至下层服务，其他请求信息拦截
        ctx.addZuulRequestHeader(CommonConstant.REQUEST_HEADER,token);
        return null;
    }
}
