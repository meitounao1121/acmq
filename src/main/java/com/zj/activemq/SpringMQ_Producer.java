package com.zj.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.TextMessage;

@Service
public class SpringMQ_Producer {
    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringMQ_Producer producer = (SpringMQ_Producer) ctx.getBean("springMQ_Producer");
        producer.jmsTemplate.send((session)->{
            TextMessage textMessage = session.createTextMessage("spring+mq");
            return textMessage;
        });
        System.out.println("=========================");
    }


}
