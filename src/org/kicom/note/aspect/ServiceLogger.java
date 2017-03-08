package org.kicom.note.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component  //扫描到Spring容器
@Aspect
public class ServiceLogger {
	
	@Before("within(org.kicom.note.controller..*)") //通知
	public void slogger(){
		System.out.println("进入Service方法");
	}
}
