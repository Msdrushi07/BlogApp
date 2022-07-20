package com.example.demo.blog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.blog.Services.Commentservice;
import com.example.demo.blog.entity.Comment;
import com.example.demo.blog.exception.ResourcenotfoundException;





@RestController
@RequestMapping("/comment")
public class Commentcontroller {
	@Autowired
	private Commentservice commentservice;
	@PostMapping("/post/{id}/comments")
	public Comment savecomment(@PathVariable int id, @RequestBody Comment comment) throws ResourcenotfoundException {
		return commentservice.savecomment(id, comment);
	}
	
	@GetMapping("/get")
	public List<Comment> getcomment(){
		return commentservice.getcomment();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletecomment(@PathVariable int id) {
		commentservice.deletecomment(id);
	}

}
