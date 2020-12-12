package com.adamp.languages.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adamp.languages.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Long> {
	List<Language> findAll();
	

}
