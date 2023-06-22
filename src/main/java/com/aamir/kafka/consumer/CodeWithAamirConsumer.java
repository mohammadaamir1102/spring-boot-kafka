package com.aamir.kafka.consumer;

import org.json.JSONObject;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CodeWithAamirConsumer {

    @KafkaListener(topics = "${service.topic.codeWithAamirTopic}")
    public void consumingMessage(String message) {
        String consumingValue = new JSONObject(message).getString("message");
        System.out.println("consumingValue is " + consumingValue);

    }
}
