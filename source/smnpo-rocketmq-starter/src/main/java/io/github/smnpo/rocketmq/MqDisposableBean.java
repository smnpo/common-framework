package io.github.smnpo.rocketmq;

import com.aliyun.openservices.ons.api.Consumer;
import com.aliyun.openservices.ons.api.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author: Ming.Zhao
 * @create: 2019-05-10 13:48
 **/
@Slf4j
@Component
public class MqDisposableBean implements DisposableBean, ExitCodeGenerator {
    @Autowired
    ApplicationContext applicationContext;

    @Override
    public void destroy() throws Exception {
        Producer producer = applicationContext.getBean(Producer.class);
        if (producer != null && producer.isStarted()) {
            producer.shutdown();
            log.info("<<<<<<<<<<<producer is shutdown>>>>>>>>>>>>>>>");
        }
        Consumer consumer = applicationContext.getBean(Consumer.class);
        if (consumer != null && consumer.isStarted()) {
            consumer.shutdown();
            log.info("<<<<<<<<<<<consumer is shutdown>>>>>>>>>>>>>>>");
        }
    }

    @Override
    public int getExitCode() {
        return 5;
    }
}
