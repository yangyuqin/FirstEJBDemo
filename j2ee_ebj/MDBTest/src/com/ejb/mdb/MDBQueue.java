package com.ejb.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by gao on 16-3-28.
 */
@MessageDriven(activationConfig = {@ActivationConfigProperty(propertyName = "destinationType",
        propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination",
                propertyValue = "/queue/myqueue")})



public class MDBQueue implements MessageListener {
    public MDBQueue() {
    }


    @Override
    public void onMessage(Message message) {
        try {
            TextMessage tmsg = (TextMessage) message;
            System.out.println("收到消息：" + tmsg.getText());
        } catch (JMSException e) {
            e.printStackTrace();

        }
    }
}
