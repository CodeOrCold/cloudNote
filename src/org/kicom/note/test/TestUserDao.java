package org.kicom.note.test;

import org.kicom.note.dao.UserDao;
import org.kicom.note.entity.User;

public class TestUserDao extends TestBase{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao userDao = getContext().getBean("userDao",UserDao.class);
		User user = userDao.findByName("demo");
	}

}
