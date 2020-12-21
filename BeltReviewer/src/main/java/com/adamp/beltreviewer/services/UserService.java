package com.adamp.beltreviewer.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.adamp.beltreviewer.models.User;
import com.adamp.beltreviewer.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    // register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
    
    // find user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    // find user by id
    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // Get all users
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
    
	 // delete user
	 public void deleteUser(Long id) {
	 	userRepository.deleteById(id);
	 	return;
	 }
	 
	//Update 
	public User updateUser(Long id, String first_name, String last_name, String location, String state, String email, String password) {
		User optionalUser = this.findUserById(id);// in the models
		optionalUser.setFirst_name(first_name);//set must match  this.first_name = fname;
		optionalUser.setLast_name(last_name);//    			 ^^this part^^	   ^ not ^
		optionalUser.setLocation(location);
		optionalUser.setState(state);
		optionalUser.setPassword(password);{
		return userRepository.save(optionalUser);
		}
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}
	
	public User createUser(@Valid User user) {
		return userRepository.save(user);
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
}