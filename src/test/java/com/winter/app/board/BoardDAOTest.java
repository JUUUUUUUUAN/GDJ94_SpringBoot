package com.winter.app.board;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.notNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class BoardDAOTest {

	@Autowired
	private BoardDAO boardDAO;
	
	@Test
	void testUpdate() throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("t", "update T");
		map.put("c", "update C");
		map.put("n", 786L);
		
		int result = boardDAO.update(map);
		assertEquals(1, result);
	}
	
//	@Test
//	void testDelete() throws Exception {
//		BoardDTO boardDTO = new BoardDTO();
//		//boardDTO.setNum(801L);
//		
//		int result = boardDAO.delete(798L);
//		assertEquals(1, result);
//	}
	
//	@Test
//	void testList() throws Exception {
//		List<BoardDTO> ar = boardDAO.list();
//		assertNotEquals(0, ar.size());
//	}
	
//	@Test
//	void testAdd() throws Exception {
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setTitle("가");
//		boardDTO.setWriter("나");
//		boardDTO.setContents("다");
//		
//		int result = boardDAO.add(boardDTO);
//		
//		assertEquals(1,result);
//	}
	
	/*@Test
	void testDetail() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(111111L);
		
		boardDTO = boardDAO.detail(boardDTO);
		//log.info(boardDTO.toString());
		
		assertNull(boardDTO);
	}*/
	
}
