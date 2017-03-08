package org.kicom.note.service;

import org.kicom.note.dao.NoteResult;

public interface NoteBookService {
	public NoteResult loadBooks(String userId);
	
	public NoteResult addBook(String bookName, String userId);
}
