package com.winter.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.util.Pager;

@Service
public class QnaService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	public List<QnaDTO> list(Pager pager) throws Exception {
		Long totalCount = qnaDAO.count(pager);
		pager.pageing(totalCount);
		return qnaDAO.list(pager);
	}
	
	public void add(QnaDTO qnaDTO) throws Exception {
		qnaDAO.add(qnaDTO);
		qnaDAO.refUpdate(qnaDTO);
	}
}
