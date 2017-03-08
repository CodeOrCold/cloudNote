package org.kicom.note.service.test;


import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kicom.note.controller.user.LoginController;
import org.kicom.note.dao.NoteResult;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})


public class TestLoginController {
	@Resource
	private LoginController controller;
	
	private MockMvc mockmvc;  //����API
	
	@Before
	public void init() {
		mockmvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void test1() throws Exception {
		//��������
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/login.do");
		//��Ӳ���
		requestBuilder.param("name", "demo").param("pwd", "123");
		//����ִ�������ȡ���ؽ��
		MvcResult mvcResult = mockmvc.perform(requestBuilder).andReturn();
		//��ȡ��Ӧ���������
		String context = mvcResult.getResponse().getContentAsString();
		System.out.println(context);
		//Ϊ�˶��Խ�jsonתΪ����
		ObjectMapper mapper = new ObjectMapper();
		NoteResult noteResult = mapper.readValue(context, NoteResult.class);
		//��ʼ����
		Assert.assertEquals(0, noteResult.getStatus());
		
	}
	
}
