package org.kicom.note.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.kicom.note.dao.NoteDao;
import org.kicom.note.dao.NoteResult;
import org.kicom.note.entity.Note;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NoteServiceImpl implements NoteService{

	@Resource
	private NoteDao notedao;
	
	@Override
	public NoteResult loadNotes(String bookId) {
		// TODO Auto-generated method stub
		
		List<Map> list = notedao.findByBookId(bookId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("查询笔记成功");
		result.setData(list);
		
		return result;
	}

	@Override
	public NoteResult hightSearch(String title, String status, Long end, Long begin) {
		// TODO Auto-generated method stub
		Map params = new HashMap();
		
		if (title != null && !"".equals(title)) {
			title = "%" + title + "%";
			params.put("title", title);
			
		}
		if (status != null && !"0".equals(status)) {
			params.put("status", status);
		}
		if (begin != null) {
			Date bDate = new Date(begin);
			params.put("beginDate", bDate.getTime());
		}
		if (end != null) {
			Date eDate = new Date(end);
			params.put("endDate", eDate.getTime());
		}
		List<Note> list = notedao.hightSearch(params);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setData(list);
		result.setMsg("检索成功");
		
		return result;
	}

}
