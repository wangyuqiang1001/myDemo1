package com.wang.activemq.activemq.producter;

import com.wang.activemq.activemq.consumer.Jmsconsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * 消息生产者
 */
@Component
public class JmsProducter {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(Destination destination, String msg) {
        this.jmsTemplate.convertAndSend(destination, msg);
    }

}
