package io.github.smnpo.rocketmq.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ming.Zhao
 * @create: 2019-05-10 11:12
 **/
@Data
@ConfigurationProperties(
        prefix = "rocketmq.consumer"
)
public class ConsumerProperties {
    private String id;
    private String accessKey;
    private String secretKey;
    private Long consumerTimeout = 5000L;
    private String messageModel = "BROADCASTING";
    private List<SubscriptionTable> subscriptions = new ArrayList<>();
}
