package org.kicom.note.dao;

import org.kicom.note.entity.User;

public interface UserDao {
	public User findByName(String name);
	public int save(User user); //增删改可以自动返回int 就是受影响的行
}
