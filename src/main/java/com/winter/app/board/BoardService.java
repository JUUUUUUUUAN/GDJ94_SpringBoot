package com.winter.app.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.notice.NoticeDTO;
import com.winter.app.util.Pager;

public interface BoardService {
	// 목록
	public List<BoardDTO> list(Pager pager) throws Exception;
	
	// 수정
	public int update(BoardDTO boardDTO) throws Exception;
	
	// 삭제
	public int delete(BoardDTO boardDTO) throws Exception;
	
	// 추가
	public int add(BoardDTO boardDTO, MultipartFile[] attach) throws Exception;
	
	// 조회
	public BoardDTO detail(BoardDTO boardDTO) throws Exception;
	
	public BoardFileDTO fileDetail(BoardFileDTO boardFileDTO) throws Exception;
}
