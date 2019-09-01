package com.wang.activemqproducter.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

@RestController
@RequestMapping(value = "/publish")
public class PublishControl {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Topic topic;
    @Autowired
    private Queue queue;

    @RequestMapping(value = "/topic")
    public String topic() {
        for (int i = 0; i < 10; i++) {
            jmsTemplate.convertAndSend(topic, "topic" + i);
        }
        return "topic 发送成功";
    }

    @JmsListener(destination = "out.queue")
    public void consume(String msg) {
        System.out.println(msg);
    }

    @RequestMapping(value = "/queue")
    public String queue() {
        for (int i = 0; i < 10; i++) {
            jmsTemplate.convertAndSend(queue, "queue" + i);
        }
        return "queue 发送成功";
    }
}
