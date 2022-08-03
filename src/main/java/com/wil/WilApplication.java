package com.wil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WilApplication {

	public static void main(String[] args) {
		SpringApplication.run(WilApplication.class, args);
	}

}
