package com.example.demo.blog.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Builder;








@Entity
@Table(name="user")
@Builder

public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int  uid;
	@NotEmpty(message="please enter name")
	private String name;
	@Email(message="please enter valid email")
	private String email;
	
	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
	public User(int uid, @NotEmpty(message = "please enter name") String name,
			@Email(message = "please enter valid email") String email, List<Post> posts) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.posts = posts;
	}
	


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<Post> posts=new ArrayList<>();
	public User orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
