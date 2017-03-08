package org.kicom.note.util;

import java.security.MessageDigest;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;


public class NoteUtil {
	public static String md5(String msg) throws Exception{
		//����MD5��msg����
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] input = msg.getBytes();
		byte[] output = md.digest(input);//��������ֽ�
		//��MD5�����outputת���ַ���
		
		//����codec��jar��
		String result = Base64.encodeBase64String(output);
		return result;
		
	}
	
	public static String createId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
}
