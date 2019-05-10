package io.github.smnpo.rocketmq.runner;

import com.aliyun.openservices.ons.api.Producer;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;

/**
 * @author: Ming.Zhao
 * @create: 2019-05-10 11:23
 **/
@Slf4j
@Data
public class ProducerRunner implements CommandLineRunner {
    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
        Producer producer = this.applicationContext.getBean(Producer.class);
        producer.start();
    }
}
