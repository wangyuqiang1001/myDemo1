package com.joymeter.rabbitproducter.controller;

import com.alibaba.fastjson.JSONObject;
import com.joymeter.rabbitproducter.topic.RabbitmqConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TopicSendControl {


//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    @RequestMapping(value = "/topicSend",method = RequestMethod.GET)
//    public String testSend (){
//        System.out.println("12343");
//        this.rabbitTemplate.convertAndSend(RabbitmqConfig.topic,"test1.wangyuqiang", "测试数据test1");
//        return  "";
//    }
//
//
//    @RequestMapping(value = "/topicSend2",method = RequestMethod.GET)
//    public String testSend2 (){
//
//        this.rabbitTemplate.convertAndSend(RabbitmqConfig.topic,"test2.xiao.hu", "测试数据2--test2");
//        return  "";
//    }
//
//    @RequestMapping(value = "/testSend",method = RequestMethod.POST)
//    public  String A(@RequestBody JSONObject msg){
//        String deviceTypeReport = msg.getString("deviceType");
//        System.out.println(deviceTypeReport);
//        return  deviceTypeReport;
//    }

}
