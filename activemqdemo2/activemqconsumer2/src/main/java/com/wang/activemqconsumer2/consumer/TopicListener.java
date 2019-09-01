package com.wang.activemqconsumer2.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicListener {
    Logger logger = LoggerFactory.getLogger(TopicListener.class);

    @JmsListener(destination = "publish.topic",
            containerFactory = "jmsListenerContainerTopic")
    public void recivev(String text) {
        logger.info(text);
    }
}
