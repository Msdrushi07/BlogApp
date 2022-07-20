package com.example.demo.blog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;


@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotEmpty
	private String comment;
	private String Commentdesc;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommentdesc() {
		return Commentdesc;
	}

	public void setCommentdesc(String commentdesc) {
		Commentdesc = commentdesc;
	}

	
	@ManyToOne
	private Post post;


	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}


}
