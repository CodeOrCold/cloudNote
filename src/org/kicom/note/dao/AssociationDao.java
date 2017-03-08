package org.kicom.note.dao;

import java.util.List;

import org.kicom.note.entity.NoteBook;
import org.kicom.note.entity.User;

public interface AssociationDao {
	public User findUser (String userId);
	public List<NoteBook> findBooks(String userId);
	
}
