package com.example.demo.blog.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.blog.Repository.Postrepo;
import com.example.demo.blog.entity.Post;


@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class PostrepoTest {
@Autowired
private Postrepo postrepo;

@Test
public void Testing() {

	Post post=postrepo.findById(12).get();
	assertEquals(post.getName(),"photos");
	
}

@Test
public void saveusertesting() {
	Post post=new Post();
	post.setName("rushi");
	post.setTitle("Photos");
	post.setContent("vlogs");
	postrepo.save(post);
	assertThat(post.getId()).isGreaterThan(0);
}

@Test
public void getuserlisttesting() {
	List<Post> posts=postrepo.findAll();
	assertThat(posts.size()).isGreaterThan(0);
}

@Test
public void updateuserlisttesting() {
	Post post=postrepo.findById(12).get();
	post.setName("rushikesh");
	Post updated=postrepo.save(post);
	assertEquals(updated.getName(),"rushikesh");
	
}
@Test
public void deleteuserTesting() {
	Post post=postrepo.findById(12).get();
	postrepo.delete(post);
	Optional<Post> posts=postrepo.findById(12);
	assertThat(posts).isEmpty();
}

}
