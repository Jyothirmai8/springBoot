package com.firstboot;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FirstbootApplication {

	static Logger log=Logger.getLogger("FirstbootApplication");
	public static void main(String[] args) {
		log.info("i am inside method main");
		SpringApplication.run(FirstbootApplication.class, args);
	}
	
	
	

}
