package com.wang.activemq.activemq.consumer;

import com.wang.activemq.activemq.config.JmsConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Jmsconsumer2 {
    private final static Logger logger = LoggerFactory.getLogger(Jmsconsumer2.class);

    @JmsListener(destination = JmsConfig.topic, containerFactory = "jmsListenerContainerFactoryTopic")
    public void onTopicMessage(String msg) {
        logger.info("接受到topic消息:{}" + msg);
    }

    @JmsListener(destination = JmsConfig.queue, containerFactory = "jmsListenerContainerFactoryQueue")
    public void onQueueMessage(String msg) {
        logger.info("接收到queue消息:{}", msg);
    }
}
