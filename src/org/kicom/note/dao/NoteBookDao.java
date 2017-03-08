package org.kicom.note.dao;

import java.util.List;

import org.kicom.note.entity.Note;
import org.kicom.note.entity.NoteBook;

public interface NoteBookDao {
	public List<NoteBook> findByUser(String userId);
	public void save(NoteBook book);
}
