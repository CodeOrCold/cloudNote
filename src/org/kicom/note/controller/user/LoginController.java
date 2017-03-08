package org.kicom.note.controller.user;

import javax.annotation.Resource;

import org.kicom.note.dao.NoteResult;
import org.kicom.note.dao.UserDao;
import org.kicom.note.entity.User;
import org.kicom.note.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //ɨ����������
@RequestMapping("/user")
public class LoginController {
	
	@Resource
	private UserService userService; //ע��
	
	
	@RequestMapping("/login.do")
	@ResponseBody //��NoteResultת����json���
	
	public NoteResult execute(String name, String pwd) throws Exception {
		
		NoteResult result = userService.checkLogin(name, pwd);
		return result;
		
	}
	
}
