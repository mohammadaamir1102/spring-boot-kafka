package com.aamir.kafka.producer;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(final String topic, JSONObject messageObject) {
        System.out.println("Producing Message " + messageObject.toString());
        this.kafkaTemplate.send(topic, messageObject.toString());
    }

}
