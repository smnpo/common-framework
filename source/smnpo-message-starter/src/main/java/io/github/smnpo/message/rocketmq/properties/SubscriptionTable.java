package io.github.smnpo.message.rocketmq.properties;

import lombok.Data;

/**
 * @author: Ming.Zhao
 * @create: 2019-05-10 11:12
 **/
@Data
public class SubscriptionTable {
    private String topic;
    private String expression;
    private String listener;
}
