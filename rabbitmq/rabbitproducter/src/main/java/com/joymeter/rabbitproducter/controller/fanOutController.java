package com.joymeter.rabbitproducter.controller;

import com.joymeter.rabbitproducter.fanout.FanoutConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/testFanout")
public class fanOutController {


    @Autowired
    private RabbitTemplate rabbitTemplate;


    @RequestMapping(value = "/fanoutSend",method = RequestMethod.GET)
    public String testSend () throws InterruptedException {
        System.out.println("12343");

        for(int i = 0 ; i<100; i++){//必须完全精确匹配:
            this.rabbitTemplate.convertAndSend(FanoutConfig.FAN_OUT_EXCHANGE,"adjsajdaj","fancout测试数据"+i);
        }

        return  "发送成功";
    }
}
