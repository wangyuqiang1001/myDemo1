package com.wang.activemq.activemq;

import com.wang.activemq.activemq.producter.JmsProducter;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Queue;
import javax.jms.Topic;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJms
public class ActivemqApplicationTests {
//@Autowired
//private JmsProducter jmsProducter;

    @Autowired
    private JmsProducter jmsProducter;
    @Autowired
    private Topic topic;
    @Autowired
    private Queue queue;

    @Test
    public void contextLoads() {
    }

//	@Test
//	public  void  testA(){
//		Destination destination = new ActiveMQQueue("spring.queue.test");
//		for(int i=0;i<10;i++) {
//			jmsProducter.sendMessage(destination, "hello world" + i);
//		}
//	}

    @Test
    public void testJms() {
        for (int i = 0; i < 10; i++) {
            jmsProducter.sendMessage(queue, "queue world" + i);
            jmsProducter.sendMessage(topic, "topic world" + i);
        }
    }

}
