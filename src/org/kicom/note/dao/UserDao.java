package org.kicom.note.dao;

import org.kicom.note.entity.User;

public interface UserDao {
	public User findByName(String name);
	public int save(User user); //��ɾ�Ŀ����Զ�����int ������Ӱ�����
}
