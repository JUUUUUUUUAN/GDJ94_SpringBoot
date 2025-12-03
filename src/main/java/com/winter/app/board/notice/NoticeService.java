package com.winter.app.board.notice;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardFileDTO;
import com.winter.app.board.BoardService;
import com.winter.app.files.FileManager;
import com.winter.app.util.Pager;

@Service
@Transactional(rollbackFor = Exception.class)
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.upload.notice}")
	private String uploadPath;
	
	public List<BoardDTO> list(Pager pager) throws Exception{
		// 1. totalCount 구하기
		Long totalCount = noticeDAO.count(pager);
		pager.pageing(totalCount);
		return noticeDAO.list(pager);
	}
	
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		return noticeDAO.detail(boardDTO);
	}
	
	@Transactional
	public int add(BoardDTO boardDTO, MultipartFile[] attach) throws Exception {
		// 글번호가 필요
		int result = noticeDAO.add(boardDTO);
		
		// 예외1. 파일이 없는 경우
		if(attach == null) {
			return result;
		}
		
		// 1. 파일을 HDD에 저장
		// 	1) 어디에 저장?
		//	2) 어떤 이름으로 저장?
		File file = new File(uploadPath);
		
		for(MultipartFile f : attach) {
			// 예외2. 생성된 input태그에 파일이 첨부되지 않은 경우
			// 3) 파일 저장
			// 4) 정보를 DB에 저장
			if(f==null || f.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(file, f);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setFileOrigin(f.getOriginalFilename());
			boardFileDTO.setBoardNum(boardDTO.getBoardNum());
			noticeDAO.fileAdd(boardFileDTO);
		}
		return result; 
	}
	
	public int update(BoardDTO boardDTO) throws Exception {
		return noticeDAO.update(boardDTO);
	}
	
	public int delete(BoardDTO boardDTO) throws Exception {
		boardDTO = noticeDAO.detail(boardDTO);
		// HDD에서 파일을 삭제
		List<BoardFileDTO> attach =  boardDTO.getFileDTOs();
		
		if(attach != null) {
			for (BoardFileDTO boardFileDTO : attach) {
				File file = new File(uploadPath, boardFileDTO.getFileName());
				boolean flag = fileManager.fileDelete(file);
			}			
		}
		
		noticeDAO.fileDelete(boardDTO);
		return noticeDAO.delete(boardDTO);
	}
	
	public BoardFileDTO fileDetail(BoardFileDTO boardFileDTO) throws Exception {
		return noticeDAO.fileDetail(boardFileDTO);
	}
	
}
