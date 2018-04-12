package cn.edu.hqu.cst.javaee.HuaMent.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.hqu.cst.javaee.HuaMent.entity.Hquer;
import cn.edu.hqu.cst.javaee.HuaMent.repository.HquerRepository;

@Controller
@RequestMapping("/hquer")
public class HquerController {
	private HquerRepository hquerRepository;
	@Autowired
	public HquerController(HquerRepository hquerRepository) {
		this.hquerRepository=hquerRepository;
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String showRegisterForm(Model model) {
		model.addAttribute(new Hquer());
		return "registerForm";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processRegistration(@Valid Hquer hquer,Errors errors) {
		if(errors.hasErrors()) {
			return "registerForm";
		}
		hquerRepository.save(hquer);
		return "redirect:/hquer/"+hquer.getUserName();
	}

	@RequestMapping(value="/{userName}",method=RequestMethod.GET)
	public String showHquerProfile(@PathVariable String userName,Model model){
		Hquer hquer=hquerRepository.findByUserName(userName);
		model.addAttribute(hquer);
		return "profile";
		
	}
}
