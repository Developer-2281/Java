package com.adamp.authentication.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.adamp.authentication.models.User;
import com.adamp.authentication.services.UserService;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserService uServ;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		// checking to see it password and confirm passwords match
		if (!user.getPasswordConfirmation().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirmation", "Match");
		}
		// checking if email is in database
		if(uServ.findByEmail(user.getEmail()) != null) {
			errors.rejectValue("duplicate", "Dupe");
		}
		
	}	

}
