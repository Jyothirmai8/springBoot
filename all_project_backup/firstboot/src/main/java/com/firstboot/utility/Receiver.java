package com.firstboot.utility;

import java.util.concurrent.CountDownLatch;


import org.springframework.kafka.annotation.KafkaListener;


public class Receiver {
	
	private CountDownLatch cc=new CountDownLatch(1);
	
	public CountDownLatch getCc() {
		return cc;
	}
	
	
/*	@KafkaListener(topics = "mytopic")
	public void receive(String m) {
		System.out.println("received message to topic "+m);
		
		cc.countDown();
	}
	
	*/

}
