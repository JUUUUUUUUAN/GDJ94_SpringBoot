package com.winter.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.util.Pager;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<NoticeDTO> list(Pager pager) throws Exception{
		// 1. totalCount 구하기
		Long totalCount = noticeDAO.countList();
		pager.pageing(totalCount);
		return noticeDAO.list(pager);
	}
	
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.detail(noticeDTO);
	}
	
	public int insert(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.insert(noticeDTO);
	}
	
	public int update(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.update(noticeDTO);
	}
	
	public int delete(Long num) throws Exception {
		return noticeDAO.delete(num);
	}
	
}
