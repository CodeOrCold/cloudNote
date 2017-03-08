package org.kicom.note.aspect;

import java.io.FileWriter;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionLogger {
	
	@AfterThrowing(throwing="exception",pointcut="within(org.kicom.note.controller..*)")
	public void log(Exception exception){
		//���쳣��Ϣд���ļ�
		System.out.println(exception);
		
		
	}
}
