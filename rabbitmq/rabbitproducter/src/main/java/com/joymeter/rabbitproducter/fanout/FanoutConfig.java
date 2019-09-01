package com.joymeter.rabbitproducter.fanout;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FanoutConfig {

    public static String FAN_OUT_EXCHANGE = "FANOUT_EXCHANGE";

    private String QUEUE_NAME = "fanoutQueue1";

    private String QUEUE_NAME2 = "fanoutQueue2";


    @Autowired
    public  CachingConnectionFactory cachingConnectionFactory;



    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FAN_OUT_EXCHANGE);
    }

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME);
    }


    @Bean
    public  Queue queue2(){
        return  new Queue(QUEUE_NAME2);
    }


    //默认会忽略路由匹配规则
    @Bean
    public Binding bindingBuilder(FanoutExchange fanoutExchange, Queue queue2) {
       return BindingBuilder.bind(queue2).to(fanoutExchange);
    }

    @Bean
    public Binding bindingBuilder2(FanoutExchange fanoutExchange, Queue queue) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }


    @Bean
    public CorrelationData correlationData() {
        return new CorrelationData();
    }



    @Bean
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory cachingConnectionFactory) {
        cachingConnectionFactory.setPublisherConfirms(true);
        cachingConnectionFactory.setPublisherReturns(true);
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback((CorrelationData correlationData, boolean ack, String cause) -> {
                    System.out.println("ConfirmCallback");
                    System.out.println(correlationData + ":" + ack + ":" + cause);
                }
        );
        //仅仅在发送失败时才会有回调内容:
        rabbitTemplate.setReturnCallback((Message message, int replyCode, String replyText, String exchange, String routingKey) -> {
            System.out.println("rentrun CallBlck");
            System.out.println(replyCode + ":" + replyText + ":" + exchange + ":" + routingKey);
        });
        return rabbitTemplate;
    }

}
