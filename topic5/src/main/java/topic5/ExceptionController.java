package topic5;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class)
	public void handleNotFound(UserNotFoundException ex) {
		System.out.println("Requested user not found");
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UserAlreadyExistsException.class)
	public void handleAlreadyExists(UserNotFoundException ex) {
		System.out.println("UserName already in use");
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ItemNotFoundException.class)
	public void handleItemNotFound(ItemNotFoundException ex) {
		System.out.println("Requested Item Not found");
	}

}
