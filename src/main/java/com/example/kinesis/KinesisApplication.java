package com.example.kinesis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

@EnableBinding({Source.class, Sink.class})
@SpringBootApplication
public class KinesisApplication {

	public static void main(String[] args) {
		SpringApplication.run(KinesisApplication.class, args);
	}

	@StreamListener("input")
	public void input(String foo) {
		System.out.println("Receive: Hello: " + foo);
	}

}
