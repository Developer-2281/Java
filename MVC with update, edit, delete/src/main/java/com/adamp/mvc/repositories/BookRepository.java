package com.adamp.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adamp.mvc.models.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	List<Book> findAll();
	List<Book> findByDescriptionContaining(String search);
	
}
