package com.mathiastechera.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@SpringBootApplication
public class GlobantProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobantProjectApplication.class, args);
	}
}
