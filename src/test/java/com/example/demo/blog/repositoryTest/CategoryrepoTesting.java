package com.example.demo.blog.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.blog.Repository.Categoryrepo;
import com.example.demo.blog.entity.Category;




@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class CategoryrepoTesting {
	@Autowired
	private Categoryrepo categoryrepo;
	@Test
	public void savecattesting() {
		Category cat=new Category();
		cat.setName("sports");
		Category cats=categoryrepo.save(cat);
		assertThat(cats.getId()).isGreaterThan(0);
	}
	
	@Test
	public void findbyidtesting() {
		Category cat=categoryrepo.findById(8).get();
		assertEquals(cat.getName(),"cricket");
	}
	
	@Test
	public void findallTesting() {
		List<Category> catlist=categoryrepo.findAll();
		assertThat(catlist.size()).isGreaterThan(0);
	}
	
	@Test
	public void updateTesting() {
		Category cat=categoryrepo.findById(8).get();
		cat.setName("rushi");
		Category updatedcat=categoryrepo.save(cat);
		assertEquals(updatedcat.getName(),"rushi");
	}
	@Test
	public void deletecattesting() {
		Category cat=categoryrepo.findById(8).get();
		categoryrepo.delete(cat);
		java.util.Optional<Category> cats=categoryrepo.findById(8);
		assertThat(cats).isEmpty();
	}

	
	
}
