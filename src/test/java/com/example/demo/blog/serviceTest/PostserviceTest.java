package com.example.demo.blog.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.blog.Repository.Postrepo;
import com.example.demo.blog.Services.Postservices;
import com.example.demo.blog.entity.Category;
import com.example.demo.blog.entity.Post;
import com.example.demo.blog.entity.User;

@SpringBootTest
public class PostserviceTest {
	
	@InjectMocks
	private Postservices postservice;
	
	@Mock
	private Postrepo postrepo;
	private Post post;

	@BeforeEach
	void setup(){
		Post post=new Post();
		post.setId(1);
		post.setName("cricket");
		post.setTitle("sports");
		post.setContent("cricket history");
		
	}
	
	/*@Test
	public void saveposttesting() {
		Post post1=new Post();
		post1.setName("cricket");
		post1.setTitle("sports");
		post1.setContent("cricket history");
		User user=new User();
		user.setUid(2);
		Category cat=new Category();
		cat.setId(3);
		Mockito.when(postrepo.save(post)).thenReturn(post);
		Post posts=postservice.savepost(2, 3,post1);
		assertThat(posts).isNotNull();
	}*/
}
