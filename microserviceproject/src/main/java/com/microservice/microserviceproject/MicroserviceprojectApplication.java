package com.microservice.microserviceproject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicroserviceprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceprojectApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper()
	{

		return new ModelMapper();
	}

}
