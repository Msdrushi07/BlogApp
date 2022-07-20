package com.example.demo.blog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.blog.Services.Postservices;
import com.example.demo.blog.entity.Post;
import com.example.demo.blog.exception.ResourcenotfoundException;



@RestController
@RequestMapping("/post")
public class Postcontroller {
	@Autowired
	private Postservices postservice;
	@PostMapping("/user/{uid}/category/{id}/posts")
	public Post savepost(@PathVariable int uid,@PathVariable int id, @RequestBody Post post) throws ResourcenotfoundException {
		return postservice.savepost(uid, id, post);
	}
	
	@GetMapping("/get")
	public List<Post> getpost(){
		return postservice.getpost();
	}
	
	@PutMapping("/update/{id}")
	public Post updatepost(@RequestBody Post post,@PathVariable int id) throws ResourcenotfoundException {
		return postservice.updatepost(post, id);
	}
	@DeleteMapping("/delete/{id}")
	public void deletepost(@PathVariable int id) {
		postservice.deletepost(id);
	}
	@GetMapping("/{uid}/posts")
	public List<Post> findpostbyuser(@PathVariable int uid){
		return postservice.findpostbyuser(uid);
	}
	
	@GetMapping("/{id}")
	public Post getbyid(@PathVariable int id) {
		return postservice.getbyid(id);
	}
}
