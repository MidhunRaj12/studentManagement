//package com.infosys.studentmanage.admin.kafka;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//import com.google.gson.Gson;
//import com.infosys.studentmanage.admin.model.Student;
//import com.infosys.studentmanage.admin.service.AdminService;
//
//@Component
//public class DataReceiver {
//
//	@Autowired
//	AdminService service;
//  
//   	@KafkaListener(topics = "${kafka.topic.event}")
//	public void receiveEvents(String payload) throws InterruptedException {
//	  Gson gson = new Gson();
//	  Student studObject = gson.fromJson(payload, Student.class);
//	//  service.updateStatus(studObject);
//	}	
//   
//}
