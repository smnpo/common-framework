package io.github.smnpo.message.rocketmq.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: Ming.Zhao
 * @create: 2019-05-10 11:12
 **/
@Data
@ConfigurationProperties(
        prefix = "rocketmq.producer"
)
public class ProducerProperties {
    private String id;
    private String accessKey;
    private String secretKey;
    private Long sendTimeout = 3000L;
}
