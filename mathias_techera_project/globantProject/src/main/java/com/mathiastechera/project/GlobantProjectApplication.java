package com.mathiastechera.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.mathiastechera.project.user")
@SpringBootApplication
public class GlobantProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobantProjectApplication.class, args);
	}
}
