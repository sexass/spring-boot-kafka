package com.example.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * 生产者
 * Created by 郭友文 on 2018/4/11.
 */
@Component
public class Producer {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMsg(String msg){
        kafkaTemplate.send("my-topic",msg);
    }
}
