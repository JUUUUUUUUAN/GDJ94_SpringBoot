package com.winter.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.winter.app.board.BoardDTO;
import com.winter.app.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/notice/*")
@Slf4j
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("list")
	public void list(Pager pager, Model model) throws Exception{
		List<BoardDTO> list = noticeService.list(pager);
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);
	}
	
	@GetMapping("add")
	public String add() {
		return "/notice/add";
	}
	
	@PostMapping("add")
	public String add(NoticeDTO noticeDTO, Model model) throws Exception {
		noticeService.add(noticeDTO);
		
		model.addAttribute("path", "list");
		return "/commons/result";
	}
	
	@GetMapping("detail")
	public String detail(BoardDTO boardDTO, Model model) throws Exception {
		boardDTO = noticeService.detail(boardDTO);
		
		// null(조회 실패 시 처리)
		if(boardDTO == null) {
			return "/notice/list";
		}
		model.addAttribute("notice", boardDTO);
		return "/notice/detail";
	}
	
}
