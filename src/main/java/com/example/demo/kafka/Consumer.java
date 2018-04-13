package com.example.demo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 消费者
 * Created by 郭友文 on 2018/4/11.
 */
@Component
public class Consumer {
    private static List<String> MSG_LIST;

    @KafkaListener(topics = {"my-topic"})
    public void recive(String data) {
        if (MSG_LIST == null) {
            MSG_LIST = new ArrayList<String>();
        }
        MSG_LIST.add(data);
    }

    public List<String> getMsgList() {
        if (MSG_LIST == null) {
            return new ArrayList<String>();
        }
        return MSG_LIST;
    }
}
