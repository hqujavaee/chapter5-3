package cn.edu.hqu.cst.javaee.HuaMent.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import cn.edu.hqu.cst.javaee.HuaMent.repository.HquerMsgRepository;
import cn.edu.hqu.cst.javaee.HuaMent.repository.impl.FakeDataRepository;
public class HquerMsgControllerTest {
	HquerMsgRepository fakeRepository=new FakeDataRepository();
	
	@Test
	public void showRecentHquerMsgList() throws Exception{
		HquerMsgController hquerMsgController=new HquerMsgController(fakeRepository);
		MockMvc mockMvc=standaloneSetup(hquerMsgController)
				.setSingleView(new InternalResourceView("/WEB-INF/views/hquerMsgList.jsp"))
				.build();
		
		mockMvc.perform(get("/hquerMsgList"))
		.andExpect(view().name("hquerMsgList"))
		.andExpect(model().attributeExists("hquerMsgList"));
	}
}
