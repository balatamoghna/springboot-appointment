package com.externship.appointment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerClass {
	@Autowired
	PersonRepository personRepo;
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@PostMapping("/registered")
	public ModelAndView registered(Person person) {
		ModelAndView mav = new ModelAndView("success");
		mav.addObject("person",person);
		personRepo.save(person);
		return mav;
		
		
	}
	
	@PostMapping("/home")
	public ModelAndView display(Person person) {
		ModelAndView mav= new ModelAndView("failure");;
		
		if(personRepo.existsById(person.getEmail()) && personRepo.findById(person.getEmail()).get().getPassword().equals(person.getPassword())) {
		mav = new ModelAndView("success");
		}
		
		mav.addObject("person",person);
		//personRepo.save(person);
		return mav;
		
		
	}

}
