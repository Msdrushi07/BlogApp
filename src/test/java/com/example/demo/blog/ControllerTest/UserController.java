package com.example.demo.blog.ControllerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.blog.Controller.Usercontroller;
import com.example.demo.blog.Services.Userservice;
import com.example.demo.blog.entity.User;




@WebMvcTest(Usercontroller.class)
public class UserController {
	@MockBean
	private Userservice userservice;
	@Autowired
	private MockMvc mockmvc;
	

	
	private User user;
	@BeforeEach
	public void setup() {									
	
	
		User user=new User();
		user.setUid(1);
		user.setName("rushi");
		user.setEmail("wwe@gmail.com");	
				
		
	}
	@Test
	public void saveusertesting() throws  Exception{
		
		Mockito.when(userservice.saveuser(user)).thenReturn(user);
		mockmvc.perform((RequestBuilder) MockMvcRequestBuilders.post("/users/save").contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "    \"name\":\"rushi\",\r\n"
						+ "    \"email\":\"wwe@gmail.com\"\r\n"
						+ "}"))
				.andExpect(MockMvcResultMatchers.status().isCreated());


	}
	
	@Test
	public void getbyidtesting() throws Exception{
		Mockito.when(userservice.getbyid(1)).thenReturn(user);
		mockmvc.perform((RequestBuilder)( get("/users/1")))
				
				.andExpect(MockMvcResultMatchers.status().isFound());
	}
	
	@Test
	public void getuserlistTesting() throws Exception {

		
		User user1=new User();		
		user1.setName("rushi");
		user1.setEmail("wwe@gmail.com");
		List<User> users=new ArrayList<>();
		users.add(user1);
		Mockito.when(userservice.getuser()).thenReturn(users);
		mockmvc.perform((RequestBuilder)get("/users/get"))
				.andExpect(MockMvcResultMatchers.status().isOk());
		
	}		
	
	@Test
	public void updateuserTesting() throws Exception {

		Mockito.when(userservice.updateuser(user,1)).thenReturn(user);
		mockmvc.perform((RequestBuilder)put("/users/update/1")
				.contentType(MediaType.APPLICATION_JSON).content("{\r\n"
						+ "\"name\":\"rushikesh\"\r\n"
						+ "\r\n"
						+ "}"))
		
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());

}		
		@Test
		public void deleteusertesting() throws Exception {
		mockmvc.perform((RequestBuilder) MockMvcRequestBuilders.delete("/users/1"))
				.andExpect(MockMvcResultMatchers.status().isOk());
				
					
		}
			
	@Test
	public void getbynametesting() throws Exception {
		Mockito.when(userservice.getuserbyname("rushi")).thenReturn(user);
		mockmvc.perform(( get("/users/get/rushi")))
		.andExpect(MockMvcResultMatchers.status().isOk());
				
	
	}
	}


	

