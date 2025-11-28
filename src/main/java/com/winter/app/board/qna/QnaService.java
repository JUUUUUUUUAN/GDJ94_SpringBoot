package com.winter.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardService;
import com.winter.app.util.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		qnaDAO.add(boardDTO);
		return qnaDAO.refUpdate(boardDTO);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.detail(boardDTO);
	}
	
	public int reply(QnaDTO qnaDTO) throws Exception {
		// 1. 부모의 정보를 조회
		BoardDTO boardDTO = qnaDAO.detail(qnaDTO);
		QnaDTO parent = (QnaDTO) boardDTO;
		// 2. 부모의 정보를 이용해서 step을 업데이트
		int result = qnaDAO.stepUpdate(parent);
		// 3. 부모의 정보를 이용해서 ref, step, depth를 세팅
		qnaDTO.setBoardRef(parent.getBoardRef());
		qnaDTO.setBoardStep(parent.getBoardStep()+1);
		qnaDTO.setBoardDepth(parent.getBoardDepth()+1);
		// 4. insert
		result = qnaDAO.add(qnaDTO);
		
		return result;
	}

	public List<BoardDTO> list(Pager pager) throws Exception {
		Long totalCount = qnaDAO.count(pager);
		pager.pageing(totalCount);
		return qnaDAO.list(pager);
	}
	
}
