package org.kicom.note.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBase {
	private static ApplicationContext ac = null;
	static{
		String conf = "applicationContext.xml";
		ac = new ClassPathXmlApplicationContext(conf);
	}
	
	public static ApplicationContext getContext() {
		return ac;
	}
	
}
