package com.github.pettyfer.basic.notice.listener;

import com.github.pettyfer.basic.common.constant.MqQueueConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Petty
 */
@Slf4j
@Component
@RabbitListener(queues = MqQueueConstant.SERVICE_STATUS_CHANGE_QUEUE)
public class ServiceStatusChangeListener {
    @RabbitHandler
    public void process(String message){
        System.out.println(message);
    }
}
