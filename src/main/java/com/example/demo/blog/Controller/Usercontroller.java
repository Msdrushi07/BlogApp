package com.example.demo.blog.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.blog.Services.Userservice;
import com.example.demo.blog.entity.User;
import com.example.demo.blog.exception.ResourcenotfoundException;

@RestController
@RequestMapping("/users")
public class Usercontroller {
	
	@Autowired
	private Userservice userservice;
@PostMapping("/save")	
public ResponseEntity<User> saveuser(@Valid @RequestBody User user) {
	User user1= userservice.saveuser(user);
	return new ResponseEntity<>(user1,HttpStatus.CREATED);
}
@GetMapping("/get")
public ResponseEntity<?> getuser(){
	return ResponseEntity.ok(userservice.getuser());
}

@GetMapping("/{uid}")
public ResponseEntity<User> getbyid(@PathVariable Integer  uid) {
	User user1=userservice.getbyid(uid);
	return new  ResponseEntity<User>(user1, HttpStatus.FOUND);
}
@DeleteMapping("/{userid}")
public void deleteuser(@PathVariable ("userid")Integer uid) {
	userservice.deleteuser(uid);
	System.out.println("user deleted");
	
}

@PutMapping("/update/{uid}")
public User updateuser(@RequestBody User user,@PathVariable Integer uid) throws ResourcenotfoundException {
	return userservice.updateuser(user, uid);
}

@GetMapping("/get/{names}")
public User getuserbyname(@PathVariable ("names")String name){
	return userservice.getuserbyname(name);
}
	
}



