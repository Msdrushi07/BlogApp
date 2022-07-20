package com.example.demo.blog.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.blog.Repository.Userrepo;
import com.example.demo.blog.entity.User;
import com.example.demo.blog.exception.ResourcenotfoundException;





@Service
public class Userservice {
	@Autowired
	private Userrepo userrepo;
	
	public User saveuser(User user) {
		return userrepo.save(user);
	}
	
	public List<User> getuser(){
		return userrepo.findAll();
	}
	
	public User getbyid(int uid)  {
		try {
		return userrepo.findById(uid).get();
		}
		catch(Exception e) {
			throw new ResourcenotfoundException("user");
		}
	}
	
	public void deleteuser(int uid) {
	userrepo.deleteById(uid);
	}
	
	public User updateuser(User user,int uid) throws ResourcenotfoundException {
		User user1=userrepo.findById(uid).orElseThrow(()-> new ResourcenotfoundException("user"));
		user1.setName(user.getName());
		user1.setEmail(user.getEmail());
	User newuser=userrepo.save(user1);
		return newuser;
	}
	

public User getuserbyname(String name){

	return userrepo.getUserByName(name);
}

	
}
