package com.github.pettyfer.basic.notice.config;

import com.github.pettyfer.basic.common.constant.MqQueueConstant;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 创建消息队列
 * @author Petty
 */
@Configuration
public class MqQueueConfig {

    @Bean
    public Queue createQueue(){
        return new Queue(MqQueueConstant.SERVICE_STATUS_CHANGE_QUEUE);
    }

}
