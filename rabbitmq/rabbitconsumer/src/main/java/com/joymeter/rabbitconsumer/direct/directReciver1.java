package com.joymeter.rabbitconsumer.direct;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = "directQueue1")
public class directReciver1 {


//    @RabbitHandler
//    public void receive(Message msg, Channel channel) throws IOException {
//        channel.basicAck(msg.getMessageProperties().getDeliveryTag(),false);
//        System.out.println("DirectReciver1接收到的消息:" + msg);
//    }

    @RabbitHandler
    public void receive(String reciveer, Channel channel, Message msg) throws IOException {
        String msgs = new String(msg.getBody());
        System.out.println("DirectRecive1接收到的消息:" + reciveer);
        try {
            if (Integer.valueOf(reciveer) == 8900) {
                channel.basicReject(msg.getMessageProperties().getDeliveryTag(), true);
            } else {
                channel.basicAck(msg.getMessageProperties().getDeliveryTag(), false);
            }
        } catch (IOException e) {
            try {
                System.out.println("发生异常");
                //require boolean （是否需要重新入队，如果为true则代表当前队列是必须的,会重新入队被分发给其他消费者）
                channel.basicReject(msg.getMessageProperties().getDeliveryTag(), true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            // e.printStackTrace();
        }
    }
}
