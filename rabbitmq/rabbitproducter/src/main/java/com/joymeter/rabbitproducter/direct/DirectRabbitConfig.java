package com.joymeter.rabbitproducter.direct;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DirectRabbitConfig {

//    @Value("${spring.rabbitmq.host}")
//    private String host;
//    @Value("${spring.rabbitmq.port}")
//    private String port;
//    @Value("${spring.rabbitmq.username}")
//    private String username;
//    @Value("${spring.rabbitmq.password}")
//    private String password;
//
//    public static String DIRECT_EXCHANGE_NAME = "DIRECT_EXCHANGE";
//
//    private String QUEUE_NAME = "directQueue1";
//
//    private String ROUTE_KEY = "directTest";

//    @Autowired
//    public  CachingConnectionFactory cachingConnectionFactory;



//    @Bean
//    public DirectExchange directExchange() {
//        return new DirectExchange(DIRECT_EXCHANGE_NAME);
//    }
//
//    @Bean
//    public Queue queue() {
//        return new Queue(QUEUE_NAME);
//    }
//
//
//    @Bean
//    public Binding bindingBuilder(DirectExchange directExchange, Queue queue) {
//        return BindingBuilder.bind(queue).to(directExchange).with(ROUTE_KEY);
//    }
//
//    @Bean
//    public CorrelationData correlationData() {
//        return new CorrelationData();
//    }
//
//
//    @Bean
//    public CachingConnectionFactory cachingConnectionFactory(){
//        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
//        cachingConnectionFactory.setUsername(username);
//        cachingConnectionFactory.setPassword(password);
//        cachingConnectionFactory.setHost(host);
//        return  cachingConnectionFactory;
//    }
//
//
//    @Bean
//    public RabbitTemplate rabbitTemplate(CachingConnectionFactory cachingConnectionFactory) {
//        /**
//         * 如果消息没有到exchange,则confirm回调,ack=false
//         * 如果消息到达exchange,则confirm回调,ack=true
//         * exchange到queue成功,则不回调return
//         * exchange到queue失败,则回调return(需设置mandatory=true,否则不会回调,消息就丢了)
//         */
//        /**
//         * 若使用confirm-callback或return-callback，必须要配置publisherConfirms或publisherReturns为true
//         * 每个rabbitTemplate只能有一个confirm-callback和return-callback，如果这里配置了，那么写生产者的时候不能再写confirm-callback和return-callback
//         * 使用return-callback时必须设置mandatory为true，或者在配置中设置mandatory-expression的值为true
//         */
//        cachingConnectionFactory.setPublisherConfirms(true);
//        cachingConnectionFactory.setPublisherReturns(true);
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
//        rabbitTemplate.setMandatory(true);
//        rabbitTemplate.setConfirmCallback((CorrelationData correlationData, boolean ack, String cause) -> {
//                    System.out.println("ConfirmCallback");
//                    System.out.println(correlationData + ":" + ack + ":" + cause);
//                }
//        );
//        //仅仅在发送失败时才会有回调内容:
//        rabbitTemplate.setReturnCallback((Message message, int replyCode, String replyText, String exchange, String routingKey) -> {
//            System.out.println("rentrun CallBlck");
//            System.out.println(replyCode + ":" + replyText + ":" + exchange + ":" + routingKey);
//        });
//        return rabbitTemplate;
//    }


}
