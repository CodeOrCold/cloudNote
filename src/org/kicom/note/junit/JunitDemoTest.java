package org.kicom.note.junit;

import javax.security.auth.Destroyable;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sun.org.apache.xml.internal.security.Init;

public class JunitDemoTest {
	
	@Before  //ÿ����test����ǰִ��һ��
	public void init(){
		System.out.println("��ʼ��");
	}
	
	@After
	public void destroy(){
		System.out.println("�ͷ���Դ");
	}
	
	@Test
	public void test1(){
		System.out.println("����1");
		String string = null;
		string.length();
		//ʹ�ö���API�����߼�Assert
		
		
	}
	
	@Test
	public void test2(){
		System.out.println("����2");
	}
	
	@Test
	public void test3(){
		System.out.println("����3");
	}
	
}
