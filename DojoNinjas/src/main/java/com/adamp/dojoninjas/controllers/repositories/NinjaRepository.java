package com.adamp.dojoninjas.controllers.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adamp.dojoninjas.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	List<Ninja> findAll();
}
