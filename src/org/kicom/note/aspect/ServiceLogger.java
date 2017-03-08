package org.kicom.note.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component  //ɨ�赽Spring����
@Aspect
public class ServiceLogger {
	
	@Before("within(org.kicom.note.controller..*)") //֪ͨ
	public void slogger(){
		System.out.println("����Service����");
	}
}
