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

import com.example.demo.blog.Controller.Postcontroller;
import com.example.demo.blog.Services.Postservices;
import com.example.demo.blog.entity.Category;
import com.example.demo.blog.entity.Post;
import com.example.demo.blog.entity.User;

@WebMvcTest(Postcontroller.class)
public class PostControllerTest {
	
	@MockBean
	private Postservices postservice;
	@Autowired
	private MockMvc mockmvc;
	private Post post;
	
	@BeforeEach
	void setup() {
		Post post=new Post();
		post.setId(1);
		post.setName("cricket");
		post.setTitle("sports");
		
		User user=new User(); 
		user.setUid(2);
		user.setName("rushi");
		user.setEmail("wwe@gmail.com");
		
		Category category=new Category();
		category.setId(3);
		category.setName("photos");
	}
	@Test
	public void savepostTesting() throws Exception {
		
		
		Mockito.when(postservice.savepost(2, 3, post)).thenReturn(post);
		mockmvc.perform(MockMvcRequestBuilders.post("/post/user/2/category/3/posts").contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "\"name\":\"cricket\",\r\n"
						+ "\"title\":\"sports\"\r\n"
						+ "}"))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void getlistpostTesting() throws Exception {
		Post post1=new Post();
		post1.setId(1);
		post1.setName("cricket");
		post1.setTitle("sports");
		List<Post> postlist=new ArrayList<>();
		postlist.add(post1);
		
		Mockito.when(postservice.getpost()).thenReturn(postlist);
		
		mockmvc.perform(MockMvcRequestBuilders.get("/post/get"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	
	@Test
	public void updateposttesting() throws Exception {
		
		Mockito.when(postservice.updatepost(post, 1)).thenReturn(post);
		mockmvc.perform(MockMvcRequestBuilders.put("/post/update/1").contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "\"name\":\"cric\",\r\n"
						+ "\"title\":\"sportss\"\r\n"
						+ "\r\n"
						+ "}"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void deletepostTesting() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.delete("/post/delete/1"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void postlistbyusertesting() throws Exception {
	
			Post post1=new Post();
			post1.setId(1);
			post1.setName("cricket");
			post1.setTitle("sports");
			List<Post> postlist=new ArrayList<>();
			postlist.add(post1);
		Mockito.when(postservice.findpostbyuser(2)).thenReturn(postlist);
		mockmvc.perform(MockMvcRequestBuilders.get("/post/2/posts"))
		.andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	
	@Test
	public void getbyidtesting() throws Exception {
		Mockito.when(postservice.getbyid(1)).thenReturn(post);
		mockmvc.perform(MockMvcRequestBuilders.get("/post/1"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
				
	
	
	
}
