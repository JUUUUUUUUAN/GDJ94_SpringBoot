package com.winter.app.board.notice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.winter.app.util.Pager;

@Mapper
public interface NoticeDAO {
	// 목록
	public List<NoticeDTO> list(Pager pager) throws Exception;
	
	// 수정
	public int update(NoticeDTO noticeDTO) throws Exception;
	
	// 삭제
	public int delete(Long num) throws Exception;
	
	// 추가
	public int add(NoticeDTO noticeDTO) throws Exception;
	
	// 조회
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception;
	
	// 목록 합계 
	public Long countList(Pager pager) throws Exception;
	
}
