package org.kicom.note.controller.note;

import javax.annotation.Resource;

import org.kicom.note.dao.NoteResult;
import org.kicom.note.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/note")
public class HighSearchController {
	
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/hightSearch.do")
	@ResponseBody
	public NoteResult execute(String title, String status, Long begin, Long end){
		NoteResult result = noteService.hightSearch(title, status, end, begin);
		return result;
		
	}

}
