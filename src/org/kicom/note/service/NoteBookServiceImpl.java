package org.kicom.note.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.kicom.note.dao.NoteBookDao;
import org.kicom.note.dao.NoteResult;
import org.kicom.note.entity.NoteBook;
import org.kicom.note.util.NoteUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NoteBookServiceImpl implements NoteBookService{
	
	@Resource
	private NoteBookDao bookDao;

	@Override
	public NoteResult loadBooks(String userId) {
		// TODO Auto-generated method stub
		List<NoteBook> list = bookDao.findByUser(userId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("查询笔记成功");
		result.setData(list);
		
		
		return result;
	}

	@Override
	public NoteResult addBook(String bookName, String userId) {
		// TODO Auto-generated method stub
		NoteResult result = new NoteResult();
		
		NoteBook noteBook = new NoteBook();
		noteBook.setCn_notebook_name(bookName);
		noteBook.setCn_user_id(userId);
		noteBook.setCn_notebook_type_id("5");
		String noteId = NoteUtil.createId();
		noteBook.setCn_notebook_id(noteId);
		Timestamp createtime = new Timestamp(System.currentTimeMillis());
		noteBook.setCn_notebook_createtime(createtime);
		bookDao.save(noteBook);
		
		result.setStatus(0);
		result.setMsg("创建成功");
		result.setData(noteId);
		
		return result;
	}

}
