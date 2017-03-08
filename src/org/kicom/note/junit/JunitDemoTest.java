package org.kicom.note.junit;

import javax.security.auth.Destroyable;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sun.org.apache.xml.internal.security.Init;

public class JunitDemoTest {
	
	@Before  //每调用test方法前执行一次
	public void init(){
		System.out.println("初始化");
	}
	
	@After
	public void destroy(){
		System.out.println("释放资源");
	}
	
	@Test
	public void test1(){
		System.out.println("测试1");
		String string = null;
		string.length();
		//使用断言API测试逻辑Assert
		
		
	}
	
	@Test
	public void test2(){
		System.out.println("测试2");
	}
	
	@Test
	public void test3(){
		System.out.println("测试3");
	}
	
}
