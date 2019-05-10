package io.github.smnpo.kafka.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: Ming.Zhao
 * @create: 2019-05-10 17:18
 **/
@Data
@ConfigurationProperties(
        prefix = "kafka.producer"
)
public class ProducerProperties {
    private String servers;
    private int retries;
    private int batchSize;
    private int linger;
    private int bufferMemory;
    private int maxBlockMs;
}
