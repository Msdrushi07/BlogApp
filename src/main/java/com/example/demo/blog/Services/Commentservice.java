package com.example.demo.blog.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.blog.Repository.Commentrepo;
import com.example.demo.blog.Repository.Postrepo;
import com.example.demo.blog.entity.Comment;
import com.example.demo.blog.entity.Post;
import com.example.demo.blog.exception.ResourcenotfoundException;



@Service
public class Commentservice {
@Autowired
private Commentrepo commentrepo;
@Autowired
private Postrepo postrepo;

public Comment savecomment(int id,Comment comment) throws ResourcenotfoundException  {
	Post post=postrepo.findById(id).orElseThrow(()-> new  ResourcenotfoundException("comment"));
	comment.setPost(post);
	return commentrepo.save(comment);
	
	
	
}

public List<Comment> getcomment(){
	return commentrepo.findAll();
}

public void deletecomment(int id) {
	commentrepo.deleteById(id);
}

}
