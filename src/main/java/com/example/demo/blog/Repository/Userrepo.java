package com.example.demo.blog.Repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.blog.entity.User;


@Repository
public interface Userrepo extends JpaRepository<User,Integer>{
	
@Query( "select u from User u where u.name=:n")
public User getUserByName(@Param ("n") String name);



}
