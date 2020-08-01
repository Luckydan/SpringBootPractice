package com.luckydan.kafka.consumer;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Title:Kafka消费者
 * @Description:
 * @Author: GL
 * @Date: 2020/5/17 23:35
 * @Version 1.0.0
 */
@Slf4j
@Component
public class KafkaConsumerListener {

    @Autowired
    private ConsumerFactory consumerFactory;

    /**
     * 消息过滤器,使用方法见consumerOfAutoTopic_1()方法注解
     *
     * @return
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory filterContainerFactory() {
        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory);
        // 被过滤的消息将被丢弃
        factory.setAckDiscarded(true);
        // 消息过滤策略
        factory.setRecordFilterStrategy(consumerRecord -> {
            if (Integer.parseInt(consumerRecord.value().toString()) % 2 == 0) {
                return false;
            }
            //返回true消息则被过滤
            return true;
        });
        return factory;
    }


    /**
     * 消费者的异常处理器，使用方法见consumerOfAutoTopic_1()方法注解
     *
     * @return
     */
    @Bean
    public ConsumerAwareListenerErrorHandler consumerAwareErrorHandler() {
        return (message, exception, consumer) -> {
            System.out.println("消费异常：" + message.getPayload());
            return null;
        };
    }


    /**
     * kafka 中指定消费组中的指定topic的消费者
     *
     * @param record
     * @param topic
     * @param consumer
     */
    @KafkaListener(groupId = "test-consumer-group", topics = "autoTopic_1", errorHandler = "consumerAwareErrorHandler", containerFactory = "filterContainerFactory")
    public void consumerOfAutoTopic_1(ConsumerRecord<?, ?> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic, Consumer consumer) {

        log.info("单独消费者消费消息,topic= {} ,content = {}", topic, record.value());
        log.info("consumer content = {}", consumer);
    }

    /**
     * kafka 中设定了批量消费，所以需要以List的形式接收消息
     *
     * @param records
     */
    @KafkaListener(groupId = "test-consumer-group", topics = "zt-dms-cbprotect")
    public void consumerOfCbprotect(List<ConsumerRecord<String, Object>> records) {
        for (ConsumerRecord<String, Object> record :
                records) {
            log.info("单独消费者消费消息,topic= {} ,content = {}", record.topic(), record.value());
            log.info("consumer content = {}", record.headers());
        }
    }


    /**
     * 指定Topic,指定Partition，指定Offset进行消费
     * @param record
     */
   /* @KafkaListener(id="consumers_1",groupId = "test-consumer-group",topicPartitions = {
            @TopicPartition(topic = "autoTopic_1",partitions ={ "0"}),
            @TopicPartition(topic = "autoTopic_2",partitions = "0",partitionOffsets = @PartitionOffset(partition = "1",initialOffset = "3"))
    })
    public void aimTopicAndPartitionAndOffsetConsumer(ConsumerRecord<?,?> record){
        System.out.println("topic:"+record.topic()+"|partition:"+record.partition()+"|offset:"+record.offset()+"|value:"+record.value());
    }*/


    /**
     * 消息转发，将autoTopic_1中的胸袭处理后，再转发到autoTopic_2中
     *
     * @param record
     * @return
     */
    @KafkaListener(topics = {"autoTopic_1"})
    @SendTo("autoTopic_2")
    public String onMessage7(ConsumerRecord<?, ?> record) {
        return record.value() + "-forward message";
    }
}