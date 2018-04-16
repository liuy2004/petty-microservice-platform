package com.github.pettyfer.basic.gateway.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger文档聚合
 *
 * @author Petty
 */
@Component
@Primary
public class SwaggerResourceProvider implements SwaggerResourcesProvider {

    private final RouteLocator routeLocator;

    @Autowired
    public SwaggerResourceProvider(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }

    /**
     * 注册资源
     * @return Swagger资源集合
     */
    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> swaggerResources = new ArrayList<>(10);
        List<Route> routes = routeLocator.getRoutes();
        routes.forEach(route -> swaggerResources.add(serviceResources(route.getId(), route.getFullPath().replace("**", "v2/api-docs"))));
        return swaggerResources;
    }

    /**
     * @param id       服务id
     * @param location 服务文档地址
     * @return Swagger资源
     */
    private SwaggerResource serviceResources(String id, String location) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setSwaggerVersion("2.0");
        swaggerResource.setName(id);
        swaggerResource.setLocation(location);
        return swaggerResource;
    }
}
