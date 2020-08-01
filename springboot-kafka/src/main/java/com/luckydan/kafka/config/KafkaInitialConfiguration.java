package com.luckydan.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Title: Kafka初始化配置类
 * @Description: 通过该配置，自动创建Topic,但topic只有一个分区，没有副本
 * @Author: GL
 * @Date: 2020/7/29 21:57
 * @Version 1.0.0
 */
@Configuration
public class KafkaInitialConfiguration {
    @Bean
    public NewTopic initialTopic(){
        return new NewTopic("autoTopic_1", 1,(short)1);
    }

    @Bean
    public NewTopic updateTopic(){
        return new NewTopic("autoTopic_2",1,(short)1);
    }


}
