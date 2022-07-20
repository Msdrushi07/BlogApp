package com.example.demo.blog.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.blog.Repository.Categoryrepo;

import com.example.demo.blog.Services.Categoryservice;

import com.example.demo.blog.entity.Category;
import com.example.demo.blog.exception.ResourcenotfoundException;


@SpringBootTest
public class CategoryserviceTest {
	@Autowired
	private Categoryservice categoryservice;
	@MockBean
	private Categoryrepo categoryrepo;
	private Category category;


	
	@BeforeEach
	void setup() {
		Category category=new Category();
		category.setId(1);
		category.setName("sports");
	
		Mockito.when(categoryrepo.findById(1)).thenReturn(Optional.of(category));
	
	}
			
	@Test
	public void savecategorytesting() {
		Category category=new Category();
		category.setId(1);
		category.setName("sports");
		Mockito.when(categoryrepo.save(category)).thenReturn(category);	
		Category cat=categoryservice.savecat(category);
		assertEquals(cat.getName(),"sports");
		
	}
	
	@Test
	public void getcategorytesting() {
		
		Category category1=new Category();
	
		category1.setName("sports");
		List<Category> catlist=new ArrayList<>();
		catlist.add(category1);
		Mockito.when(categoryrepo.findAll()).thenReturn(catlist);
	List<Category> cats =categoryservice.getcat();
	assertEquals(cats.size(),1);
	}
	
	@Test
	public void getcategorybyidtesting() {
		Category cat=categoryservice.getbyid(1);
		assertEquals(cat.getName(),"sports");
	}
	
	@Test
	public void updatecategorytesting() {
		Category cat=categoryservice.getbyid(1);
		cat.setName("cricket");
	Category cats=	categoryservice.updatecat(cat, 1);
	assertEquals(cat.getName(),"cricket");
		
	}
	
	@Test
	public void deleteusertesting() {

		categoryservice.deletecat(1);
		verify(categoryrepo,times(1)).deleteById(1);
	
	
  }
	
	@Test
	public void getbyidtesting() {
	Category cat=	categoryservice.getbyid(1);
	assertEquals(cat.getName(),"sports");
	}
	
	@Test
	public void getbyidfails() {
		org.junit.jupiter.api.Assertions.assertThrows(ResourcenotfoundException.class,()->{
			categoryservice.getbyid(10);
		});
	}
	@Test
	public void updatecatfails() {
		org.junit.jupiter.api.Assertions.assertThrows(ResourcenotfoundException.class,()->{
		categoryservice.getbyid(10);
		});
	}
	
	
	}
	
	
	

