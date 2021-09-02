package com.example.kinesis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class MessageController {
    @GetMapping("hello")
    String hello() {
        return "hello";
    }

    @Autowired
    private Source source;

    @GetMapping("send")
    public void sendMessage() {
        UUID id = UUID.randomUUID();
        System.out.println("Before sending : " + id);
        source.output().send(MessageBuilder.withPayload(id).build());
        System.out.println("After sending : " + id);
    }
}
