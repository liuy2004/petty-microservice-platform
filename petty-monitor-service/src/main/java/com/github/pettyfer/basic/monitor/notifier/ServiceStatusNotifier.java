package com.github.pettyfer.basic.monitor.notifier;

import de.codecentric.boot.admin.event.ClientApplicationEvent;
import de.codecentric.boot.admin.event.ClientApplicationStatusChangedEvent;
import de.codecentric.boot.admin.notify.AbstractStatusChangeNotifier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.text.SimpleDateFormat;

/**
 * @author Petty
 */
@Slf4j
public class ServiceStatusNotifier extends AbstractStatusChangeNotifier {

    public static final String STATUS_CHANGE = "STATUS_CHANGE";

    private RabbitTemplate rabbitTemplate;

    public ServiceStatusNotifier(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    protected boolean shouldNotify(ClientApplicationEvent event) {
        boolean shouldNotify = false;
        if (STATUS_CHANGE.equals(event.getType())
                && event.getApplication().getStatusInfo().isOffline()
                || event.getApplication().getStatusInfo().isDown()) {
            shouldNotify = true;
        }
        return shouldNotify;
    }

    @Override
    protected void doNotify(ClientApplicationEvent clientApplicationEvent) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (clientApplicationEvent instanceof ClientApplicationStatusChangedEvent) {
            log.info("Service {} ({}) is {}", clientApplicationEvent.getApplication().getName(),
                    clientApplicationEvent.getApplication().getId(), ((ClientApplicationStatusChangedEvent) clientApplicationEvent).getTo().getStatus());
            String message = String.format("服务:%s 下线，时间：%s", clientApplicationEvent.getApplication().getName(), simpleDateFormat.format(clientApplicationEvent.getTimestamp()));
            rabbitTemplate.convertAndSend(message);
        } else {
            log.info("Service {} ({}) {}", clientApplicationEvent.getApplication().getName(),
                    clientApplicationEvent.getApplication().getId(), clientApplicationEvent.getType());
        }
    }
}
