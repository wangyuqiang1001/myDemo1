package com.joymeter.rabbitconsumer.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanoutQueue2")
public class fanoutReciver3 {

    @RabbitHandler
    public void reciver(String msg) {
        System.out.println("fanoutReciver3" + msg);
    }
}