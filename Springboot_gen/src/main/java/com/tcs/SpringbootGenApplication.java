package com.tcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tcs.service.UserService;

@SpringBootApplication
public class SpringbootGenApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext bean = SpringApplication.run(SpringbootGenApplication.class, args);
		
		UserService U = bean.getBean(UserService.class);
		
		U.dataIns();
	}

}
