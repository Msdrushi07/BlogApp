package com.example.demo.blog.exception;




public class ResourcenotfoundException extends RuntimeException  {
	
	String message;

	public ResourcenotfoundException(String message) {
		super(String.format("%s not found",message));
		this.message = message;
		
		
	}
	


	
	

	

	

	

}
