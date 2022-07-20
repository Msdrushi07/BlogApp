package com.example.demo.blog.ControllerTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.blog.Controller.Commentcontroller;
import com.example.demo.blog.Services.Commentservice;
import com.example.demo.blog.entity.Comment;
import com.example.demo.blog.entity.Post;

@WebMvcTest(Commentcontroller.class)
public class CommentcontrollerTest {

	@MockBean
	private Commentservice commentservice;
	
	@Autowired
	private MockMvc mockmvc;
	private Comment comment;
	
	@BeforeEach
	void setup() {
		Comment comment=new Comment();
		comment.setId(1);
		comment.setComment("amazing");
		comment.setCommentdesc("just amazing");
		
		Post post=new Post();
		post.setId(2);
		post.setName("sports");
		post.setTitle("cricket");
		post.setContent("cricket photos");
		
	
	}
	
	@Test
	public void savecommentTesting() throws Exception {
		
		Mockito.when(commentservice.savecomment(2,comment)).thenReturn(comment);
		mockmvc.perform(MockMvcRequestBuilders.post("/comment/post/2/comments").contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "\"comment\":\"amaze\",\r\n"
						+ "\"commentdesc\":\"just amazing\"\r\n"
						+ "}"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void getcommentTesting() throws Exception {
Comment comment1=new Comment();
		
		comment1.setComment("amazing");
		comment1.setCommentdesc("just amazing");
		List<Comment> comlist=new ArrayList<>();
		comlist.add(comment1);
		Mockito.when(commentservice.getcomment()).thenReturn(comlist);
		mockmvc.perform(MockMvcRequestBuilders.get("/comment/get"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void deletecommentTesting() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.delete("/comment/delete/1"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
