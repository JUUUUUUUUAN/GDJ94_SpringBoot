package com.winter.app.board.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	public java.util.List<NoticeDTO> List() throws Exception{
		return noticeDAO.list();
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
