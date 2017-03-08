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

@Service //ɨ��service���
@Transactional
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao; //ע��
	
	public NoteResult checkLogin(String name, String pwd) throws Exception{
		NoteResult result = new NoteResult();
		
		User user = userDao.findByName(name);
		
		if (user == null) {
			result.setStatus(1);
			result.setMsg("�û�������");
			return result;
		}
		//���û������������ܺ������ݿ�ȶ�
		String md5_pwd = NoteUtil.md5(pwd);
		
		if (!user.getCn_user_password().equals(md5_pwd)) {
			result.setStatus(2);
			result.setMsg("���벻��ȷ");
			return result;
		}
		result.setStatus(0);
		result.setMsg("�û�����������ȷ");
		result.setData(user.getCn_user_id());//�����û�id
		return result;
	}

	@Override
	public NoteResult regist(String name, String password, String nickname) throws Exception {
		// TODO Auto-generated method stub
		NoteResult noteResult = new NoteResult();
		
		//����û����Ƿ�ռ��
		User has_user = userDao.findByName(name);
		if (has_user != null) {
			noteResult.setStatus(1);
			noteResult.setMsg("�û����ѱ�ռ��");
			return noteResult;
		}
		
		//ע��
		User user = new User();
		user.setCn_user_name(name);
		user.setCn_user_desc(nickname);
		String md5_pwd = NoteUtil.md5(password);
		user.setCn_user_password(md5_pwd);
		String userId = NoteUtil.createId();
		user.setCn_user_id(userId);
		//����userDao����
		userDao.save(user);
		noteResult.setStatus(0);
		noteResult.setMsg("ע��ɹ�");
		
		return noteResult;
	}
	
}
