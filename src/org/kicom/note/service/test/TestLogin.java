package org.kicom.note.service.test;

import org.junit.Assert;
import org.junit.Test;
import org.kicom.note.dao.NoteResult;
import org.kicom.note.service.UserService;
import org.kicom.note.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sun.print.resources.serviceui;

public class TestLogin {

	private UserService service;
	
	@Test
	public void test1(){
		String conf="applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		service = ac.getBean("userServiceImpl",UserService.class);
		
		
	}
	
	@Test
	public void test2() throws Exception{
		NoteResult result = service.checkLogin("demo", "123");
		Assert.assertEquals("2", result.getStatus());
		
		
	}
	
	@Test
	public void test3(){
		
	}
}
