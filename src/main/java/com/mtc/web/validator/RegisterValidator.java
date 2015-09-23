package com.mtc.web.validator;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mtc.app.vo.Register;
@Component("registerValidator")
public class RegisterValidator implements Validator {

	
	private List<String> userslist;
	@PostConstruct //this annotation indicates that this is an init method for the bean
	public void initRegisterValidator(){
		userslist = new ArrayList<String>();
		userslist.add("maggy");
		userslist.add("margret");
		userslist.add("adlin");
		}
	@Override
	public boolean supports(Class<?> class1) {
		if(class1.equals(Register.class)){
			return true;
		}
		return false;
	}

	@Override
	public void validate(Object commandObject, Errors errors) {
		
		Register register=(Register)commandObject;
		if(userslist.contains(register.getUsername())){
		errors.rejectValue("username", "error.user.name", "username taken");
	}
	}

}
