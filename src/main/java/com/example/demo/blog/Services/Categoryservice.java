package com.example.demo.blog.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.blog.Repository.Categoryrepo;
import com.example.demo.blog.entity.Category;
import com.example.demo.blog.exception.ResourcenotfoundException;

@Service
public class Categoryservice {

	@Autowired
	private Categoryrepo categoryrepo;
	
	public Category savecat(Category category) {
		return categoryrepo.save(category);
	}
	
	public List<Category> getcat(){
		return categoryrepo.findAll();
	}

	public Category getbyid(int id) throws ResourcenotfoundException {
		return categoryrepo.findById(id).orElseThrow(()-> new ResourcenotfoundException("category"));
	}
	
	public void deletecat(int id) {
	categoryrepo.deleteById(id);
	}
	
	public Category updatecat(Category category,int id) throws ResourcenotfoundException {
		Category cat=categoryrepo.findById(id).orElseThrow(()-> new ResourcenotfoundException("category"));	
		cat.setName(category.getName());
		Category newcat= categoryrepo.save(cat);
		return newcat;
	}
	
	
}
