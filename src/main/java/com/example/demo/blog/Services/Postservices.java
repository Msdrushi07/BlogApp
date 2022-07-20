package com.example.demo.blog.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.blog.Repository.Categoryrepo;
import com.example.demo.blog.Repository.Postrepo;
import com.example.demo.blog.Repository.Userrepo;
import com.example.demo.blog.entity.Category;
import com.example.demo.blog.entity.Post;
import com.example.demo.blog.entity.User;
import com.example.demo.blog.exception.ResourcenotfoundException;



@Service
public class Postservices {
	
	@Autowired
	private Postrepo postrepo;
	@Autowired
	private Userrepo userrepo;
	@Autowired
	private Categoryrepo categoryrepo;
	
public Post savepost(int uid,int id,Post post) throws ResourcenotfoundException {
	
	User user=userrepo.findById(uid).orElseThrow(()-> new ResourcenotfoundException("post"));
	Category category=categoryrepo.findById(id).orElseThrow(()-> new ResourcenotfoundException("post"));
	post.setUser(user);
	post.setCategory(category);
	return postrepo.save(post);
	
	
}

public Post getbyid(int id) {
	return postrepo.findById(id).get();
}


public List<Post> getpost(){
	 List<Post> posts=postrepo.findAll();
return posts;
}

public void deletepost(int id) {
	postrepo.deleteById(id);
}

public Post updatepost(Post post,int id) throws ResourcenotfoundException {
	Post post1=postrepo.findById(id).orElseThrow(()-> new ResourcenotfoundException("post"));
	post1.setName(post.getName());
	post1.setContent(post.getContent());
	return postrepo.save(post1);
	
}

public List<Post> findpostbyuser(int uid) {
	User user=userrepo.findById(uid).orElseThrow(()-> new ResourcenotfoundException("user"));
	List<Post>  posts=postrepo.findByUser(user);
	return posts;
}
}
