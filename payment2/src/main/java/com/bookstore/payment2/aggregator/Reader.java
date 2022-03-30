package com.bookstore.payment2.aggregator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class Reader {

    public void processOrder(Message<List> ordermessage){
        
        System.out.println("Orders");
        List payments = new ArrayList();
        payments = ordermessage.getPayload();
        for(Object pay: payments){
            System.out.println(pay.toString());
        }
    }

	
}
