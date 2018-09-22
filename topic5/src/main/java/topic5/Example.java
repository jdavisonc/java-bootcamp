package topic5;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class Example {

	@RequestMapping("/")
	String home() {
		return "Service is working!";
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Example.class, args);
	}

}