package com.joymeter.rabbitconsumer.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
//@RabbitListener(queues = "queue1")
public class topicReciver {

//    @RabbitHandler
//    public  void  receive(String msg ){
//        System.out.println("接收到的消息:" + msg);
//    }
}
