package com.luckydan.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.internals.Topic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Title: kafka生产者
 * @Description:
 * @Author: GL
 * @Date: 2020/5/17 23:11
 * @Version 1.0.0
 */
@Slf4j
@Controller
public class KafkaController {
    @Resource
    private KafkaTemplate<String,String> kafkaTemplate;

    /**
     * 通过接口作为消息的生产者
     * @param message
     * @return
     */
    @RequestMapping(value="sendMessage")
    @ResponseBody
    public String sentMessage(@RequestBody String message){

        //String message = UUID.randomUUID().toString()+"你大爷永远是你大爷";
        // 当kafka中没有手动创建zt-dms-cbprotect时，执行kafkaTemplate.send（）时会自动创建该topic
        // 这种情况下创建的topic默认只有一个分区，分区也没有副本
        ListenableFuture listenableFuture = kafkaTemplate.send("zt-dms-cbprotect",message);
        listenableFuture.addCallback(
                o -> log.info("消息发送成功,{}", o.toString()),
                throwable -> log.info("消息发送失败,{}" + throwable.getMessage())
        );
        return "消息发送成功！！！";
    }

    /**
     * 带回调的消息生产者
     * @return
     */
    @GetMapping(value="/kafka/callback/{sendMessage}")
    @ResponseBody
    public String productCallBack(@PathVariable("sendMessage") String sendMessage){
        kafkaTemplate.send("zt-dms-cbprotect",sendMessage).addCallback(success ->{
            // 消息生产者的目标topic
            String topic = success.getRecordMetadata().topic();
            // 消息发送到的分区
            int partition = success.getRecordMetadata().partition();
            // 消息在分区中的offset
            long offset = success.getRecordMetadata().offset();
            //生产者发送的消息体
            String value = success.getProducerRecord().value();
            System.out.println("发送消息成功："+topic + "分区："+partition+"offset:"+offset+"消息体"+value);
        },failure->{
            System.out.println("消息发送失败："+failure.getMessage());
        });
        return "Hello World";
    }

    /**
     * 带事物的消息生产者,当出现错误时消息不回发出
     * @return
     */
    @GetMapping(value="/kafka/transaction/{sendMessage}")
    public void sendMessageWithTransaction(@PathVariable("sendMessage") String message){
        kafkaTemplate.executeInTransaction(operations ->{
            operations.send("autoTopic_1",message+"kakfa_topic_456");
            operations.send("autoTopic_2",message+"____123");
            throw new RuntimeException("sent Message Failed!!!");
        });
    }
}
