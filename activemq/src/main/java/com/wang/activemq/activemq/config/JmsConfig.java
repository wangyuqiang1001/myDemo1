package com.wang.activemq.activemq.config;

import com.sun.tracing.ProbeName;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTempTopic;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class JmsConfig {
    public static final String topic = "springboot.topic";
    public static final String queue = "springboot.queue";

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(queue);
    }

    @Bean
    public Topic topic() {
       return  new ActiveMQTopic(topic);
    }

    /**
     * topic 模式的listener
     *
     * @param activeMQConnectionFactory
     * @return
     */
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerFactoryTopic(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }

    /**
     * queue模式的listener
     *
     * @param activeMQConnectionFactory
     * @return
     */
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerFactoryQueue(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory fac = new DefaultJmsListenerContainerFactory();
        fac.setConnectionFactory(activeMQConnectionFactory);
        return fac;
    }
}
