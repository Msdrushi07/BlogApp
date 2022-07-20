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

import com.example.demo.blog.Repository.Commentrepo;
import com.example.demo.blog.entity.Comment;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class CommentrepoTest {
@Autowired
private Commentrepo commentrepo;

@Test
public void findbyidTesting() {
	Comment comment=commentrepo.findById(23).get();
	assertEquals(comment.getComment(),"amazing");

}

@Test
public void savecommenttesting() {
	Comment comment=new Comment();
	comment.setComment("new");
	comment.setCommentdesc("new disc");
	Comment com=commentrepo.save(comment);
	assertThat(com.getId()).isGreaterThan(0);
	
}

@Test
public void findalltesting() {
	List<Comment> com=commentrepo.findAll();
	assertThat(com.size()).isGreaterThan(0);
}

@Test
public void deletecommenttesting() {

	commentrepo.deleteById(23);
	Optional<Comment> comm=commentrepo.findById(23);
	assertThat(comm).isEmpty();
}


}
