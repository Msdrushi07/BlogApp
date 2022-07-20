package com.example.demo.blog.serviceTest;
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

import com.example.demo.blog.Repository.Userrepo;
import com.example.demo.blog.Services.Userservice;
import com.example.demo.blog.entity.Category;
import com.example.demo.blog.entity.User;
import com.example.demo.blog.exception.ResourcenotfoundException;




@SpringBootTest
public class UserservicesTesting {

	@Autowired
	private Userservice userservice;
	@MockBean
	private Userrepo userrepo;
	private  User user;
	

	@BeforeEach
	void setup() {
		User user=new User();
		user.setUid(1);
		user.setName("rushi");
		user.setEmail("wwe@gmail.com");
		Mockito.when(userrepo.getUserByName("rushi")).thenReturn(user);
		Mockito.when(userrepo.findById(1)).thenReturn(Optional.of(user));
		Mockito.when(userrepo.getUserByName("rushi")).thenReturn(user);
		
	}
	
	
	
	@Test
	public void getbynameTesting() {
		
		String name="rushi";
		
		
		User user=userservice.getuserbyname(name);
		assertEquals( user.getUid(),1);
				}
	
	
	@Test
	public void getbyidTesting() {
		
		int uid=1;
		User user=userservice.getbyid(uid);
		assertEquals("rushi", user.getName());
				}
		
	@Test
	public void saveusertesting() {
		User user=new User();
		user.setUid(1);
		user.setName("rushi");
		user.setEmail("wwe@gmail.com");
		Mockito.when(userrepo.save(user)).thenReturn(user);
		User newuser=userservice.saveuser(user);
		assertEquals(newuser.getName(),"rushi");
	}
	
	@Test
	public void getalltesting() {
		User user1=new User();
		user1.setUid(1);
		user1.setName("rushi");
		user1.setEmail("wwe@gmail.com");
		List<User> list=new ArrayList<>();
		list.add(user1);
		Mockito.when(userrepo.findAll()).thenReturn(list);
		List<User> users=userservice.getuser();
		assertEquals(users.size(),1);
	
	}
	
	@Test
	public void updateusertesting() {
		
		User user=userservice.getbyid(1);
		Mockito.when(userrepo.save(user)).thenReturn(user);
		user.setName("rushikesh");
		User updated=userservice.updateuser(user,1);
		
	assertEquals(updated.getName(),"rushikesh");
		
		
		
	}
	
	@Test
	public void deleteusertesting() {

		userservice.deleteuser(1);
		verify(userrepo,times(1)).deleteById(1);
	
	
  }

	
	@Test
	public void getbyidfails() {
		org.junit.jupiter.api.Assertions.assertThrows(ResourcenotfoundException.class,()->{
			userservice.getbyid(10);
		});
	}
	
	
	
	
	
	

	
}