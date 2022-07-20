package com.example.demo.blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.blog.entity.Comment;


@Repository
public interface Commentrepo extends JpaRepository<Comment,Integer> {

}
