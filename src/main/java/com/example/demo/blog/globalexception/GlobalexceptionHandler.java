package com.example.demo.blog.globalexception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.blog.exception.ErrorMessage;
import com.example.demo.blog.exception.ResourcenotfoundException;

@RestControllerAdvice
public class GlobalexceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourcenotfoundException.class)
	public ResponseEntity<ErrorMessage> Resoursenotfoundexceptionhandler(ResourcenotfoundException exception){
		
		ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
		return  new ResponseEntity<ErrorMessage>(message,HttpStatus.NOT_FOUND);
		
		
	}

	public ResponseEntity<Object> MethodargumentexceptionHandler(MethodArgumentNotValidException exception){

		Map<String,String> resp=new HashMap<>();
		exception.getBindingResult().getAllErrors().forEach((a) -> {
			String fieldname= ((FieldError) a).getField();
			String message=a.getDefaultMessage();
			resp.put(fieldname,message);
		});
		return new ResponseEntity<Object>(resp,HttpStatus.BAD_REQUEST);
		
	}
	

}
