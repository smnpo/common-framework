package io.github.smnpo.rocketmq.annotation;

import java.lang.annotation.*;

/**
 * @author: Ming.Zhao
 * @create: 2019-05-10 10:26
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ConsumerListener {

    String topic() default "";

    String expression() default "*";
}
