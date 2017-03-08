package org.kicom.note.service;

import org.kicom.note.dao.NoteResult;

public interface UserService {
	public NoteResult checkLogin(String name, String pwd) throws Exception;
	
	public NoteResult regist(String name, String password, String nickname) throws Exception;
}
