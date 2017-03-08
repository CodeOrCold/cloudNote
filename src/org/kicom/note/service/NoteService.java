package org.kicom.note.service;

import org.kicom.note.dao.NoteResult;

public interface NoteService {
	public NoteResult loadNotes(String bookId);
	
	public NoteResult hightSearch(String title, String status, Long end, Long begin);
}
   