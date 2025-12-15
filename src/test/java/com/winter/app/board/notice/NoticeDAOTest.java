package com.winter.app.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class NoticeDAOTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
//	void testCountList() throws Exception {
//		int result = noticeDAO.conutList();
//		
//		assertEquals(366, result);
//	}
	
//	@Test
//	void testList() throws Exception{
//		List<NoticeDTO> ar = new ArrayList<NoticeDTO>();
//		ar = noticeDAO.list();
//		
//		assertNotNull(ar);
//	}
	
	
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
//	@Rollback(false)
//	void testAdd() throws Exception{
//		for(int i=0;i<120;i++) {
//			NoticeDTO noticeDTO = new NoticeDTO();
//			noticeDTO.setBoardTitle("title"+i);
//			noticeDTO.setBoardWriter("writer"+i);
//			noticeDTO.setBoardContents("contents"+i);
//			noticeDAO.add(noticeDTO);
//			if(i%10 == 0) {
//				Thread.sleep(500);				
//			}
//		}
//		
//		//int result = noticeDAO.insert(noticeDTO);
//		//assertEquals(1, result);
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
