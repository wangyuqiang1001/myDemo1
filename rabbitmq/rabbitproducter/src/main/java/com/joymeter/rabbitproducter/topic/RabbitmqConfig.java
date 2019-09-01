package com.joymeter.rabbitproducter.topic;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitmqConfig {
    //topic
//    public   static  final String topic = "TOPIC.EXCHANGE";
//
//    //queue
//    private static  final  String queue1 = "queue1";
//
//    private static  final  String queue2 = "queue2";
//
//    public static  String ROUTE_KEY1 = "test1.*";
//
//    public static  String Route_key2 = "test2.#";
//
//
//
//    @Bean
//    public Queue testQueue1(){
//        return new Queue(queue1);
//    }
//    @Bean
//    public Queue testQueue2(){
//        return  new Queue(queue2);
//    }
//    @Bean
//    public TopicExchange topicExchange (){
//        return  new TopicExchange(topic);
//    }
//
//    @Bean
//    public Binding bindToExchange1(Queue testQueue1, TopicExchange topicExchange) {
//        return BindingBuilder.bind(testQueue1).to(topicExchange).with(ROUTE_KEY1);
//    }
//
//    @Bean
//    public Binding bindToExchange2(Queue testQueue2, TopicExchange topicExchange) {
//        return BindingBuilder.bind(testQueue2).to(topicExchange).with(Route_key2);
//    }


}
