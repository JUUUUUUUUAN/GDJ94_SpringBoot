package com.winter.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.notice.NoticeDTO;
import com.winter.app.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@Value("${category.board.qna}")
	private String category;
	
	@ModelAttribute("category")
	public String getCategory() {
		return this.category;
	}
	
	@GetMapping("list")
	public String list(Model model, Pager pager) throws Exception {
		List<BoardDTO> list = qnaService.list(pager);
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@GetMapping("add")
	public String add() throws Exception {
		return "board/add";
	}
	
	@PostMapping("add")
	public String add(QnaDTO qnaDTO, MultipartFile [] attach) throws Exception {
		qnaDTO.setBoardRef(0L);
		qnaDTO.setBoardStep(0L);
		qnaDTO.setBoardDepth(0L);
		qnaService.add(qnaDTO, attach);
		return "redirect:/qna/list";	
	}
	
	@GetMapping("detail")
	public String detail(QnaDTO qnaDTO, Model model) throws Exception {
		BoardDTO dto = qnaService.detail(qnaDTO);
		QnaDTO notice = (QnaDTO) dto;
		model.addAttribute("notice", notice);
		return "board/detail";
	}
	
	@GetMapping("reply")
	public String reply(QnaDTO qnaDTO, Model model) throws Exception{
		model.addAttribute("dto", qnaDTO);
		return "board/add";
	}
	
	@PostMapping("reply")
	public String reply(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.reply(qnaDTO);
		return "redirect:./list";
	}
	
	@GetMapping("update")
	public String update(BoardDTO boardDTO, Model model) throws Exception {
		boardDTO = qnaService.detail(boardDTO);
		model.addAttribute("updateDto", boardDTO);
		model.addAttribute("sub", "update");
		return "/board/add";
	}
	
	@PostMapping("update")
	public String update(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.update(qnaDTO);
		return "redirect:./detail?boardNum="+qnaDTO.getBoardNum();
	}
	
}
