package com.wang.activemqconsumer2.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class QueueListener {
    private Logger logger= LoggerFactory.getLogger(QueueListener.class);
    @JmsListener(destination = "publish.queue",containerFactory = "jmsListenerContainerQueue")
    @SendTo("out.queue")
    public  String recieve(String text){
      logger.info(text);
      return  "consumer-a recieved :" +text;
    }
}
