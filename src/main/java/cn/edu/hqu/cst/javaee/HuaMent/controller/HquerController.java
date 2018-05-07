package cn.edu.hqu.cst.javaee.HuaMent.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.hqu.cst.javaee.HuaMent.config.WebConfig;
import cn.edu.hqu.cst.javaee.HuaMent.entity.Hquer;
import cn.edu.hqu.cst.javaee.HuaMent.repository.HquerRepository;

@Controller
@RequestMapping("/hquer")
public class HquerController {
	private HquerRepository hquerRepository;
	private final ResourceLoader resourceLoader; 
 
	@Autowired
	public HquerController(HquerRepository hquerRepository,ResourceLoader resourceLoader) {
		this.hquerRepository=hquerRepository;
		this.resourceLoader=resourceLoader;
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String showRegisterForm(Model model) {
		model.addAttribute(new Hquer());
		return "registerForm";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processRegistration(@Valid Hquer hquer,Errors errors) throws IllegalStateException, IOException {
		if(errors.hasErrors()) {
			return "registerForm";
		}
		Files.copy(hquer.getPic().getInputStream(), Paths.get(WebConfig.ROOT, hquer.getUserName()+".jpeg"));  
		hquerRepository.save(hquer);
		return "redirect:/hquer/"+hquer.getUserName();
	}

	@RequestMapping(value="/{userName}",method=RequestMethod.GET)
	public String showHquerProfile(@PathVariable String userName,Model model){
		Hquer hquer=hquerRepository.findByUserName(userName);
		model.addAttribute(hquer);
		return "profile";
		
	}
	 @RequestMapping(method = RequestMethod.GET, value = "/pic/{filename:.+}")  
	 @ResponseBody  
	public  ResponseEntity<?> getFile(@PathVariable String filename) {
		 System.out.println("here is ok");
		return ResponseEntity.ok(resourceLoader.getResource("file:"+Paths.get(WebConfig.ROOT, filename).toString()));  
	}
}
