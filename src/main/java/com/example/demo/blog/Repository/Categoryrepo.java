package com.example.demo.blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.blog.entity.Category;

@Repository
public interface Categoryrepo extends JpaRepository<Category,Integer>{

}
