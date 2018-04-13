package com.example.demo.controller;

import com.example.demo.kafka.Consumer;
import com.example.demo.kafka.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试用接口
 * Created by 郭友文 on 2018/4/11.
 */
@RestController
@RequestMapping("/kafka")
public class TestController {
    @Autowired
    Producer producer;
    @Autowired
    Consumer consumer;
    /**
     *发送消息
     *@param msg 消息
     *@return
     */
    @RequestMapping(value = "/send",method = RequestMethod.GET)
    public String sendMessage(String msg){
        producer.sendMsg(msg);
        return msg;
    }

    /**
     *展示收到的消息
     *@param
     *@return
     */
    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public List<String> showMessage(){
        return consumer.getMsgList();
    }
}
