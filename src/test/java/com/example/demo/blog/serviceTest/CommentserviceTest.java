package com.example.demo.blog.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.assertj.core.api.AbstractOptionalIntAssert;
import java.util.Optional;
import com.example.demo.blog.Repository.Commentrepo;
import com.example.demo.blog.Repository.Postrepo;
import com.example.demo.blog.Services.Commentservice;
import com.example.demo.blog.Services.Postservices;
import com.example.demo.blog.entity.Comment;
import com.example.demo.blog.entity.Post;

@SpringBootTest
public class CommentserviceTest {
	
	@Autowired
	private Commentservice commentservice;
	
	@Autowired
	private Postrepo postrepo;
	@Autowired
	private Postservices postservice;
	
	@MockBean
	private Commentrepo commentrepo;
	
	private Comment comment;
	private Post post;

	@BeforeEach
	void setup() {
		

		Post post=new Post();
		post.setId(2);
		post.setName("sports");
		post.setTitle("cricket");
		
		Comment comment=new Comment();
		comment.setId(1);
		comment.setComment("amazing");
		comment.setCommentdesc("just amazing");
		comment.setPost(post);
		
		Mockito.when(commentrepo.save(comment)).thenReturn(comment);
		
	}
	
	/*@Test
	public void savecommentTesting() {	
		
		Comment com=commentservice.savecomment(2, comment);
		assertEquals(com.getComment(),"amazing");
		
	}*/
	
	@Test
	public void getlisttesting() {
		Comment comment1=new Comment();
		comment1.setComment("amazing");
		comment1.setCommentdesc("just amazing");
		List<Comment> comlist=new ArrayList<>();
		comlist.add(comment1);
		Mockito.when(commentrepo.findAll()).thenReturn(comlist);
		List<Comment> coms=commentservice.getcomment();
		assertEquals(coms.size(),1);
	}
	
	@Test
	public void deleteusertesting() {

		commentservice.deletecomment(1);
		verify(commentrepo,times(1)).deleteById(1);
	
	
  }
	
}
