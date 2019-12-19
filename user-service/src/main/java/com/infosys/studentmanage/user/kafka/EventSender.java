package com.infosys.studentmanage.user.kafka;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.infosys.studentmanage.user.model.Attendance;

@Component
public class EventSender {


	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${kafka.topic.event}")
	private String topic;

	public void send(Attendance payload) throws InterruptedException, ExecutionException {
		
		Gson gson = new Gson();
		String json = gson.toJson(payload);
		kafkaTemplate.send(topic, json);
		System.out.println("Message has been posted to Subscriber");
	}
}
