package com.example.demo.blog.ControllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

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
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.blog.Controller.Categorycontroller;
import com.example.demo.blog.Services.Categoryservice;
import com.example.demo.blog.entity.Category;

@WebMvcTest(Categorycontroller.class)
public class CategoryControllerTest {
	@Autowired
private	MockMvc mockmvc;
@MockBean
private Categoryservice categoryservice;
private Category category;
@BeforeEach
public void setup() {
	Category category=new Category();
	category.setId(1);
	category.setName("sports");
}


	@Test
	public void savecattesting() throws Exception {
		
		Mockito.when(categoryservice.savecat(category)).thenReturn(category);
		mockmvc.perform((RequestBuilder)  MockMvcRequestBuilders.post("/category/save").contentType(MediaType.APPLICATION_JSON)
				.content("\r\n"
						+ "{\r\n"
						+ "\"name\":\"sports\"\r\n"
						+ "}\r\n"
						+ ""))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void getcatidTesting() throws Exception {
		Mockito.when(categoryservice.getbyid(1)).thenReturn(category);
		mockmvc.perform(( MockMvcRequestBuilders.get("/category/get/1")))
		.andExpect(MockMvcResultMatchers.status().isOk());
				
				
	}
	
	@Test
	public void getcatlistTesting() throws Exception {
		Category category1=new Category();

		category1.setName("sports");
		List<Category> catlist=new ArrayList<>();
		catlist.add(category1);
		Mockito.when(categoryservice.getcat()).thenReturn(catlist);
		mockmvc.perform((RequestBuilder)get("/category/get"))
		.andExpect(MockMvcResultMatchers.status().isOk());

	}
	
	@Test
	public void updatecattesting() throws Exception {
		
		
		Mockito.when(categoryservice.updatecat(category,1)).thenReturn(category);
		mockmvc.perform(MockMvcRequestBuilders.put("/category/update/1").contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "\"name\":\"cricket\"\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "}"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void deleteusertesting() throws Exception {
	mockmvc.perform((RequestBuilder) MockMvcRequestBuilders.delete("/category/delete/1"))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
