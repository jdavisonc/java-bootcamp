package topic5;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@EnableAutoConfiguration
@SpringBootApplication
public class Example {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Example.class, args);
	}

}