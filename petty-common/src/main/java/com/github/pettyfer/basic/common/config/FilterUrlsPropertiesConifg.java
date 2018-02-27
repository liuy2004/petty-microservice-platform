package com.github.pettyfer.basic.common.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 需要过滤的URL
 *
 * @author Petty
 * @since 2018年2月27日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@ConditionalOnExpression("!'${urls}'.isEmpty()")
@ConfigurationProperties(prefix = "urls")
public class FilterUrlsPropertiesConifg {
    private List<String> anon = new ArrayList<>();
}
