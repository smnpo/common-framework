package io.github.smnpo.message.rocketmq;

import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import io.github.smnpo.message.rocketmq.properties.ProducerProperties;
import io.github.smnpo.message.rocketmq.runner.ProducerRunner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author: Ming.Zhao
 * @create: 2019-05-10 11:58
 **/
@Slf4j
@Configuration
@EnableConfigurationProperties(ProducerProperties.class)
@ConditionalOnProperty(
        prefix = "rocketmq.producer",
        name = "id"
)
public class ProducerAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public Producer producer(ProducerProperties producerProperties) {
        Properties properties = new Properties();
        properties.setProperty(PropertyKeyConst.ProducerId, producerProperties.getId());
        properties.setProperty(PropertyKeyConst.AccessKey, producerProperties.getAccessKey());
        properties.setProperty(PropertyKeyConst.SecretKey, producerProperties.getSecretKey());
        properties.setProperty(PropertyKeyConst.SendMsgTimeoutMillis, String.valueOf(producerProperties.getSendTimeout()));
        //properties.setProperty(PropertyKeyConst.ONSAddr, "http://onsaddr-internal.aliyun.com:8080/rocketmq/nsaddr4client-internal");
        return ONSFactory.createProducer(properties);
    }

    @Bean
    public ProducerRunner producerRunner(ApplicationContext applicationContext) {
        ProducerRunner producerRunner = new ProducerRunner();
        producerRunner.setApplicationContext(applicationContext);
        return producerRunner;
    }
}
