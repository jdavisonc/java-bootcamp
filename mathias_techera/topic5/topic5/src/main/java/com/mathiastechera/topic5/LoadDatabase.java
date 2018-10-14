package com.mathiastechera.topic5;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
	
	@Bean
	CommandLineRunner initDatabase(UserRepository repository) {
		return args -> {			
			repository.save(new User( "jonny",  "pwdUser1" , "Jon", "Doe", "test1@example.com"));
			repository.save(new User( "steve1990",  "pwdUser2" , "Steve", "Parker", "test2@example.com"));
			repository.save(new User( "amurdock",  "pwdUser3" , "Ana", "Murdock", "test3@example.com"));
			repository.save(new User( "anita",  "pwdUser3" , "Ana", "Murdock", "test3@example.com"));			
		};
	}
}
