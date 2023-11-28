package com.microservice.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	User getUserByUserId(int userId);

//	@Query("userId:?0")
//	User getUserById(int userId);
//	@Query("{author : ?0}")                                         // SQL Equivalent : SELECT * FROM BOOK where author = ?
//    List<Book> getBooksByAuthor(String author);

}
