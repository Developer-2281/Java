package com.adamp.dojoninjas.controllers.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adamp.dojoninjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();
	

}
