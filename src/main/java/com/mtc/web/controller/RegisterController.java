package com.mtc.web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mtc.app.vo.Register;
import com.mtc.web.validator.RegisterValidator;

@Controller
public class RegisterController {
	//private Logger logger = Logger.getLogger(RegisterController.class);
	
	@Autowired
	private RegisterValidator registerValidator;
	            
	@InitBinder // registers the RegisterValidator class as a validator for recognition by thre spring framework
	public void registerValidator(WebDataBinder webDataBinder){
		webDataBinder.setValidator(registerValidator);
	}
	
	@RequestMapping(value="/registerProcess",method=RequestMethod.GET)
	public String showRegisterView(ModelMap modelMap){
		//this method only registers the command object and provides the input jsp details
	//logger.info("*********showRegisterView()*********");
	Register register= new Register();
		
	//registers the object as a command object
	modelMap.addAttribute("register",register);
			// input jsp name
	return "register";
	}

	@RequestMapping(value="/registerProcess",method=RequestMethod.POST)//handles the form data
	public String  processRegisterRequest(@Validated Register register,BindingResult bindingResult,Model model){
		//logger.info("*********processRegisterRequest()*********");
		
	if(bindingResult.hasErrors()){
		return "register";
	}
	model.addAttribute("register",register);
	return "welcome";
	}
//	public ModelAndView processRegisterRequest(Register register){
//		logger.info("*********processRegisterRequest()*********");
//		ModelAndView modelAndView = new ModelAndView("welcome");
//		modelAndView.addObject("register", register);
//		return modelAndView;
//}
	@ModelAttribute("cities")
public ArrayList<String> getCities() {
		//logger.info("*********getCities()*********");
		ArrayList<String> citiesList = new ArrayList<String>();
	citiesList.add(" ");
	citiesList.add("Bangalore");
	citiesList.add("Chennai");
	citiesList.add("Mumbai");
	citiesList.add("Surat");
	
	return citiesList;
}
@ModelAttribute("states")
public ArrayList<String> getStates() {
	//logger.info("*********getStates() *********");
	ArrayList<String> statesList = new ArrayList<String>();
	statesList.add(" ");
	statesList.add("Karnataka");
	statesList.add("Tamil Nadu");
	statesList.add("Maharashtra");
	statesList.add("Gujarat");
	
	return statesList;
}
}