package io.github.smnpo.rocketmq.runner;

import com.aliyun.openservices.ons.api.Consumer;
import com.aliyun.openservices.ons.api.MessageListener;
import com.aliyun.openservices.ons.api.bean.ConsumerBean;
import com.aliyun.openservices.ons.api.bean.Subscription;
import com.aliyun.openservices.ons.api.impl.rocketmq.ConsumerImpl;
import io.github.smnpo.rocketmq.annotation.ConsumerListener;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringValueResolver;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: Ming.Zhao
 * @create: 2019-05-10 11:23
 **/
@Slf4j
@Data
public class ConsumerRunner implements CommandLineRunner {
    private ApplicationContext applicationContext;
    private StringValueResolver stringValueResolver;

    @Override
    public void run(String... args) throws Exception {
        Consumer consumer = (Consumer) this.applicationContext.getBean(Consumer.class);
        Map<String,Object> beans = this.applicationContext.getBeansWithAnnotation(ConsumerListener.class);
        Map<Subscription, MessageListener> subscriptionTable = new LinkedHashMap<>();
        for (Object bean : beans.values()) {
            MessageListener messageListener = (MessageListener) bean;
            ConsumerListener consumerListener = messageListener.getClass().getAnnotation(ConsumerListener.class);
            Subscription sub = new Subscription();
            String topic = stringValueResolver.resolveStringValue(consumerListener.topic());
            sub.setTopic(topic);
            sub.setExpression(consumerListener.expression());
            subscriptionTable.put(sub, messageListener);
            if (consumer instanceof ConsumerImpl) {
                ConsumerImpl consumerImpl = (ConsumerImpl) consumer;
                consumerImpl.subscribe(topic, consumerListener.expression(), messageListener);
            }
        }

        if (consumer instanceof ConsumerBean) {
            ConsumerBean consumerBean = (ConsumerBean) consumer;
            consumerBean.setSubscriptionTable(subscriptionTable);
        }

        consumer.start();
    }
}
