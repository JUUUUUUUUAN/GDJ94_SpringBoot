package com.winter.app.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NoticeDAOTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	void testList() throws Exception{
		List<NoticeDTO> ar = new ArrayList<NoticeDTO>();
		ar = noticeDAO.list();
		
		assertNotNull(ar);
	}
	
//	@Test
//	void testUpdate() throws Exception{
//		NoticeDTO noticeDTO = new NoticeDTO();
//		noticeDTO.setBoardTitle("주안");
//		noticeDTO.setBoardWriter("주주안");
//		noticeDTO.setBoardContents("주주주안");
//		noticeDTO.setBoardNum(6L);
//		
//		int result = noticeDAO.update(noticeDTO);
//		assertEquals(1, result);
//	}
	
//	@Test
//	void testDelete() throws Exception{
//		int result = noticeDAO.delete(3L);
//		assertEquals(1, result);
//	}
	
//	@Test
//	void testInsert() throws Exception{
//		NoticeDTO noticeDTO = new NoticeDTO();
//		noticeDTO.setBoardTitle("주안");
//		noticeDTO.setBoardWriter("주주안");
//		noticeDTO.setBoardContents("주주안");
//		
//		int result = noticeDAO.insert(noticeDTO);
//		assertEquals(1, result);
//	}
	
//	@Test
//	void testDetail() throws Exception {
//		NoticeDTO noticeDTO = new NoticeDTO();
//		noticeDTO.setBoardNum(1L);
//		
//		noticeDTO = noticeDAO.detail(noticeDTO);
//		
//		assertNotNull(noticeDTO);
//	}

}
