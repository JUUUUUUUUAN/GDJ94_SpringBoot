package com.winter.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardDTO;
import com.winter.app.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/notice/*")
@Slf4j
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@Value("${category.board.notice}")
	private String category;
	
	@ModelAttribute("category")
	public String getCategory() {
		return this.category;
	}
	
	@GetMapping("list")
	public String list(Pager pager, Model model) throws Exception{
		List<BoardDTO> list = noticeService.list(pager);
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);
		
		return "board/list";
	}
	
	@GetMapping("add")
	public String add() {
		return "board/add";
	}
	
	@PostMapping("add")
	public String add(NoticeDTO noticeDTO, Model model, MultipartFile[] attach) throws Exception {
		noticeService.add(noticeDTO, attach);
		
		model.addAttribute("path", "list");
		return "/commons/result";
	}
	
	@GetMapping("detail")
	public String detail(BoardDTO boardDTO, Model model) throws Exception {
		boardDTO = noticeService.detail(boardDTO);
		
		// null(조회 실패 시 처리)
		if(boardDTO == null) {
			return "redirect:./list";
		}
		model.addAttribute("notice", boardDTO);
		return "board/detail";
	}
	
	@PostMapping("delete")
	public String delete(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.delete(noticeDTO);
		return "redirect:./list";
	}
	
	@GetMapping("update")
	public String update(BoardDTO boardDTO, Model model) throws Exception {
		boardDTO = noticeService.detail(boardDTO);
		model.addAttribute("updateDto", boardDTO);
		model.addAttribute("sub", "update");
		return "/board/add";
	}
	
	@PostMapping("update")
	public String update(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.update(noticeDTO);
		return "redirect:./detail?boardNum="+noticeDTO.getBoardNum();
	}
	
}
