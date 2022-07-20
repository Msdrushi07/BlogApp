package com.example.demo.blog.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.blog.Repository.Userrepo;
import com.example.demo.blog.entity.User;
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class UserrepoTesting {
	
	@Autowired
	private Userrepo userrepo;

		
	@Test
	public void Testing() {
	
		User user=userrepo.findById(1).get();
		assertEquals(user.getName(),"rushi mane");
		
	}
	
	@Test
	public void saveusertesting() {
		User user = new User();
		user.setName("rushi mane");
		user.setEmail("wwe@gmail.com");
		userrepo.save(user);
		assertThat(user.getUid()).isGreaterThan(0);
	}
	
	@Test
	public void getuserlisttesting() {
		List<User> users=userrepo.findAll();
		assertThat(users.size()).isGreaterThan(0);
	}
	
	@Test
	public void updateuserlisttesting() {
		User user=userrepo.findById(1).get();
		user.setName("rushikesh");
		User updated=userrepo.save(user);
		assertEquals(updated.getName(),"rushikesh");
		
	}
	@Test
	public void deleteuserTesting() {
		User user=userrepo.findById(1).get();
		userrepo.delete(user);
		Optional<User> user1=userrepo.findById(1);
		assertThat(user1).isEmpty();
	}
	

}