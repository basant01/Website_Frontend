package com.example.zerone.ems;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import com.example.zerone.ems.EmsApplication;
@SpringBootApplication
@EnableJpaAuditing
@EnableWebSecurity
public class EmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
	
	}

}
