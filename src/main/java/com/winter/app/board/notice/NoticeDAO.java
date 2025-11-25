package com.winter.app.board.notice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeDAO {
	// 목록
	public List<NoticeDTO> list() throws Exception;
	
	// 수정
	public int update(NoticeDTO noticeDTO) throws Exception;
	
	// 삭제
	public int delete(Long num) throws Exception;
	
	// 추가
	public int insert(NoticeDTO noticeDTO) throws Exception;
	
	// 조회
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception;
	
}
