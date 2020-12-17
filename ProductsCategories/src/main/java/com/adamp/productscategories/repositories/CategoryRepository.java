package com.adamp.productscategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adamp.productscategories.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category> findAll();
	
	// If using model name category cntr shft o will not work.
	// must hover over category and import models from drop down menu
}
