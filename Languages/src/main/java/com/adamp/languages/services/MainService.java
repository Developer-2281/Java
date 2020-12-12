package com.adamp.languages.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.adamp.languages.models.Language;
import com.adamp.languages.repository.LanguageRepository;

@Service
public class MainService {
	private final LanguageRepository langRepo;
	
	public MainService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}
	
	public LanguageRepository getLangRepo() {// will not edit or delete without this
		return langRepo;
	}

	// Get all Languages
	public List<Language> getAllLanguages() {
		return this.langRepo.findAll();
	}
	// Find Language by ID
	public Language findLanguageById(Long id) {
		return this.langRepo.findById(id).orElse(null);
	}

	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = langRepo.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	// Create a Language
	
	public void createLanguage(Language language) {
		this.langRepo.save(language);
	}
	
	public void deleteLanguage(Long id) {
		langRepo.deleteById(id);
		return;
	}

	public Language update(Long id, String langName, String creator, String version) {
		Language optionalLanguage = this.findLanguage(id);
		optionalLanguage.setLangName(langName);
		optionalLanguage.setCreator(creator);
		optionalLanguage.setVersion(version); {
			return langRepo.save(optionalLanguage);
		}
	}
	// update from html/ sent thru controller
	public Language update(Language filledLang) {
		return langRepo.save(filledLang);
		// TODO Auto-generated method stub
		
	}

}
