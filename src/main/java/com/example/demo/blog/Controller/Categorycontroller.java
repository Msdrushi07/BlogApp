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

import com.example.demo.blog.Services.Categoryservice;
import com.example.demo.blog.entity.Category;
import com.example.demo.blog.exception.ResourcenotfoundException;



@RestController
@RequestMapping("/category")
public class Categorycontroller {
@Autowired
private Categoryservice categoryservice;
@PostMapping("/save")
public Category savecat(@RequestBody Category category) {
	return categoryservice.savecat(category);
}

@GetMapping("/get")
public List<Category> getcat(){
	return categoryservice.getcat();
}

@GetMapping("/get/{id}")
public Category getbyid(@PathVariable int id) throws ResourcenotfoundException {
	return categoryservice.getbyid(id);
}

@DeleteMapping("/delete/{id}")
public void deletecat(@PathVariable int id) {
	 categoryservice.deletecat(id);
	 System.out.println("category deleted");
}

@PutMapping("/update/{id}")
public Category Updatecat(@RequestBody Category category,@PathVariable int id) throws ResourcenotfoundException {
	return categoryservice.updatecat(category, id);
	
}
}
