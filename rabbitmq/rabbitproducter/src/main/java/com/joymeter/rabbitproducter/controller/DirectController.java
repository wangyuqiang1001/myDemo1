package com.joymeter.rabbitproducter.controller;

import com.joymeter.rabbitproducter.direct.DirectRabbitConfig;
import com.joymeter.rabbitproducter.topic.RabbitmqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/testDirect")
public class DirectController {


    @Autowired
    private RabbitTemplate rabbitTemplate;

//    @RequestMapping(value = "/directSend",method = RequestMethod.GET)
//    public String testSend () throws InterruptedException {
//        System.out.println("12343");
//
//        for(int i = 0 ; i<10000; i++){//必须完全精确匹配:
//            this.rabbitTemplate.convertAndSend(DirectRabbitConfig.DIRECT_EXCHANGE_NAME,"directTest", String.valueOf(i));
//        }
//
//        return  "发送成功";
//    }
}
