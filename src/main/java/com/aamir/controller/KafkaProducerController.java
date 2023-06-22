package com.aamir.controller;

import com.aamir.kafka.producer.CodeWithAamirProducer;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codeWithAamir/kafka")
public class KafkaProducerController {


    @Autowired
    private CodeWithAamirProducer codeWithAamirProducer;

    @Value("${service.topic.codeWithAamirTopic}")
    public String codeWithAamir;

    @GetMapping("/publishMessage")
    public ResponseEntity<String> publishKafkaMessage(@RequestParam("message") String message) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", message);
        System.out.println("message value is " + message);
        codeWithAamirProducer.sendMessage(codeWithAamir, jsonObject);
        return ResponseEntity.ok("Message has been sent check console for consuming value");
    }

}
