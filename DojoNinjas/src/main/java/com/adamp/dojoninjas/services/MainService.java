package com.adamp.dojoninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adamp.dojoninjas.controllers.repositories.DojoRepository;
import com.adamp.dojoninjas.controllers.repositories.NinjaRepository;
import com.adamp.dojoninjas.models.Dojo;
import com.adamp.dojoninjas.models.Ninja;

@Service
public class MainService {
	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	
	// add all the repos here.
	
	public MainService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	
	public DojoRepository getDojoRepo() {
		return dojoRepo;
	}

	public NinjaRepository getNinjaRepo() {
		return ninjaRepo;
	}
	
	//------------------------Dojo Methods-----------------------//

	// Get all Dojos
	public List<Dojo> getAllDojos() {
		return dojoRepo.findAll();  // removed .this
	}
	// Find Dojo by ID
	public Dojo findDojoById(Long id) {
		return dojoRepo.findById(id).orElse(null); // removed .this
	}

	// Create a Dojo
	
	public void createDojo(Dojo dojo) {
		this.dojoRepo.save(dojo);
	}
	// delete a Dojo
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
		return;
	}

	// Update 
	public Dojo update(Long id, String name) {
		Dojo optionalDojo = this.findDojoById(id);
		optionalDojo.setName(name);
		return dojoRepo.save(optionalDojo);
		}

	//------------------------End Dojo Methods-----------------------//
	

	//------------------------Ninja Methods-----------------------//
	

	// Get all Ninjas
	public List<Ninja> getAllNinjas() {
		return this.ninjaRepo.findAll();
	}
	// Find Ninja by ID
	public Ninja findNinjaById(Long id) {
		return this.ninjaRepo.findById(id).orElse(null);
	}
	
	// Create a Ninja
	
	public void createNinja(Ninja ninja) {
		this.ninjaRepo.save(ninja);
	}
	// delete a Ninja
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
		return;
	}

	// Update 
	public Ninja update(Long id, String fname, String lname, Integer age) {
		Ninja optionalNinja = this.findNinjaById(id);// in the models
		optionalNinja.setFirst_name(fname);//set must match  this.first_name = fname;
		optionalNinja.setLast_name(lname);//    			 ^^this part^^	   ^ not ^
		optionalNinja.setAge(age); {
		return ninjaRepo.save(optionalNinja);
		}
	}

	//------------------------End Ninja Methods-----------------------//
}
