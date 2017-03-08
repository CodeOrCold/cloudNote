package org.kicom.note.dao;

import java.util.List;
import java.util.Map;

import org.kicom.note.entity.Note;


public interface NoteDao {
	public List<Map> findByBookId(String bookId);
	
	public Note findById(String noteId);
	
	public List<Note> hightSearch(Map params);
	
	public void dynamicUpdate(Note note);
}
