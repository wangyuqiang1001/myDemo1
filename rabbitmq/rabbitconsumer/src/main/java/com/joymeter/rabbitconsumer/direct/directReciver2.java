package com.joymeter.rabbitconsumer.direct;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@RabbitListener(queues = "directQueue1")
public class directReciver2 {

    /**
     * deliveryTag（唯一标识 ID）：当一个消费者向 RabbitMQ 注册后，会建立起一个 Channel ，
     * RabbitMQ 会用 basic.deliver 方法向消费者推送消息，这个方法携带了一个 delivery tag，
     * 它代表了 RabbitMQ 向该 Channel 投递的这条消息的唯一标识 ID，是一个单调递增的正整数，delivery tag 的范围仅限于 Channel
     * multiple：为了减少网络流量，手动确认可以被批处理，当该参数为 true 时，则可以一次性确认 delivery_tag 小于等于传入值的所有消息
     * <p>
     * 同样的，如果要nack或者拒绝消息（reject）的时候，
     * 也是调用channel里面的basicXXX方法就可以了（要指定tagId）。
     * <p>
     * 注意：如果抛异常或nack（并且requeue为true（代表当前消息是否需要，需要即重新入队）），消息会重新入队列，
     * 并且会造成消费者不断从队列中读取同一条消息的假象。
     */
    // 确认消息
    // 如果 channel.basicAck   channel.basicNack  channel.basicReject 这三个方法都不执行，消息也会被确认
    // 所以，正常情况下一般不需要执行 channel.basicAck
    // channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
    /*
     * 消息的标识，false只确认当前一个消息收到，true确认consumer获得的所有消息
     * channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
     *
     * ack返回false，并重新回到队列
     * channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
     *
     * 拒绝消息
     * channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
     *
     */
    @RabbitHandler
    public void receive(String reciveer, Channel channel, Message msg) throws IOException {
        String msgs = new String(msg.getBody());
        System.out.println("DirectReciver2接收到的消息:" + reciveer);
        try {
            if (Integer.valueOf(reciveer) == 9991) {
                channel.basicReject(msg.getMessageProperties().getDeliveryTag(), true);
            } else {
                channel.basicAck(msg.getMessageProperties().getDeliveryTag(), false);
            }
        } catch (IOException e) {
            try {

                channel.basicReject(msg.getMessageProperties().getDeliveryTag(), false);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }


}
