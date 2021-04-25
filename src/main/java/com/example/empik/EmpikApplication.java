package com.example.empik;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmpikApplication {

	private static final Logger log = LoggerFactory.getLogger(EmpikApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmpikApplication.class, args);
	}

}
