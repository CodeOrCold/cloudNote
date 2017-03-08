package org.kicom.note.service;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.kicom.note.dao.NoteResult;
import org.kicom.note.dao.UserDao;
import org.kicom.note.entity.User;
import org.kicom.note.util.NoteUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

@Service //扫描service组件
@Transactional
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao; //注入
	
	public NoteResult checkLogin(String name, String pwd) throws Exception{
		NoteResult result = new NoteResult();
		
		User user = userDao.findByName(name);
		
		if (user == null) {
			result.setStatus(1);
			result.setMsg("用户不存在");
			return result;
		}
		//将用户输入的密码加密后与数据库比对
		String md5_pwd = NoteUtil.md5(pwd);
		
		if (!user.getCn_user_password().equals(md5_pwd)) {
			result.setStatus(2);
			result.setMsg("密码不正确");
			return result;
		}
		result.setStatus(0);
		result.setMsg("用户名和密码正确");
		result.setData(user.getCn_user_id());//返回用户id
		return result;
	}

	@Override
	public NoteResult regist(String name, String password, String nickname) throws Exception {
		// TODO Auto-generated method stub
		NoteResult noteResult = new NoteResult();
		
		//检测用户名是否被占用
		User has_user = userDao.findByName(name);
		if (has_user != null) {
			noteResult.setStatus(1);
			noteResult.setMsg("用户名已被占用");
			return noteResult;
		}
		
		//注册
		User user = new User();
		user.setCn_user_name(name);
		user.setCn_user_desc(nickname);
		String md5_pwd = NoteUtil.md5(password);
		user.setCn_user_password(md5_pwd);
		String userId = NoteUtil.createId();
		user.setCn_user_id(userId);
		//调用userDao保存
		userDao.save(user);
		noteResult.setStatus(0);
		noteResult.setMsg("注册成功");
		
		return noteResult;
	}
	
}
