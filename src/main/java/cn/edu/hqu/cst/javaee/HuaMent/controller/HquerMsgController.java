package cn.edu.hqu.cst.javaee.HuaMent.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.hqu.cst.javaee.HuaMent.controller.entity.HquerMsgForm;
import cn.edu.hqu.cst.javaee.HuaMent.entity.HquerMsg;
import cn.edu.hqu.cst.javaee.HuaMent.repository.HquerMsgRepository;

@Controller
@RequestMapping(value= {"/hquerMsgList"})
public class HquerMsgController{
	private static final String MAX_LONG_AS_STRING = "9223372036854775807";
	private HquerMsgRepository hquerMsgRepository;
	
	@Autowired
	public HquerMsgController(HquerMsgRepository hquerMsgRepository) {
		this.hquerMsgRepository=hquerMsgRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<HquerMsg> hquerMsgs(@RequestParam(value="max",defaultValue=MAX_LONG_AS_STRING)long max,@RequestParam(value="count",defaultValue="20") int count){
		return hquerMsgRepository.findHquerMsg(max, count);
	}
	
	@RequestMapping(value="/{hquerMsgId}",method=RequestMethod.GET)
	public String hquMsg(@PathVariable("hquerMsgId")long hquerMsgId,Model model) {
		model.addAttribute(hquerMsgRepository.findOne(hquerMsgId));
		return "hquerMsg";
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String saveHquerMsg(HquerMsgForm hquerMsgForm,Model model) {
		hquerMsgRepository.save(new HquerMsg((long) 3,hquerMsgForm.getMessage(),new Date(),hquerMsgForm.getLatitude(),hquerMsgForm.getLongitude()));
		return "redirect:/hquerMsgList";
	}
	
}