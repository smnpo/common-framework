package io.github.smnpo.message.rocketmq;

import com.aliyun.openservices.ons.api.Consumer;
import com.aliyun.openservices.ons.api.MessageListener;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import io.github.smnpo.message.rocketmq.properties.ConsumerProperties;
import io.github.smnpo.message.rocketmq.properties.ProducerProperties;
import io.github.smnpo.message.rocketmq.runner.ConsumerRunner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author: Ming.Zhao
 * @create: 2019-05-10 11:49
 **/
@Slf4j
@Configuration
@EnableConfigurationProperties({ProducerProperties.class, ConsumerProperties.class})
@ConditionalOnProperty(
        prefix = "rocketmq.consumer",
        name = "id"
)
public class ConsumerAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnBean(MessageListener.class)
    public Consumer consumer(ConsumerProperties consumerProperties) {
        Properties properties = new Properties();
        properties.setProperty(PropertyKeyConst.ConsumerId, consumerProperties.getId());
        properties.setProperty(PropertyKeyConst.AccessKey, consumerProperties.getAccessKey());
        properties.setProperty(PropertyKeyConst.SecretKey, consumerProperties.getSecretKey());
        properties.setProperty(PropertyKeyConst.ConsumeTimeout, String.valueOf(consumerProperties.getConsumerTimeout()));
        properties.setProperty(PropertyKeyConst.MaxReconsumeTimes, "2");
        properties.setProperty(PropertyKeyConst.MessageModel, consumerProperties.getMessageModel());

        return ONSFactory.createConsumer(properties);
    }

    @Bean
    public ConsumerRunner consumerRunner(ApplicationContext applicationContext) {
        ConsumerRunner consumerRunner = new ConsumerRunner();
        consumerRunner.setApplicationContext(applicationContext);
        return consumerRunner;
    }

}
