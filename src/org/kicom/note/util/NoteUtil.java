package org.kicom.note.util;

import java.security.MessageDigest;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;


public class NoteUtil {
	public static String md5(String msg) throws Exception{
		//利用MD5对msg处理
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] input = msg.getBytes();
		byte[] output = md.digest(input);//处理的是字节
		//将MD5处理的output转成字符串
		
		//引入codec的jar包
		String result = Base64.encodeBase64String(output);
		return result;
		
	}
	
	public static String createId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
}
