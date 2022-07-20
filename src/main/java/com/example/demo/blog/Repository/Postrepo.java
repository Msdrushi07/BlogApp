package com.example.demo.blog.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.blog.entity.Post;
import com.example.demo.blog.entity.User;


@Repository
public interface Postrepo extends JpaRepository<Post,Integer>{
	List<Post> findByUser(User user);

}
