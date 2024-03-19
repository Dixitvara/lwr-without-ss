package com.withoutss.lwr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LwrApplication {

	public static void main(String[] args) {
		SpringApplication.run(LwrApplication.class, args);
	}

}
