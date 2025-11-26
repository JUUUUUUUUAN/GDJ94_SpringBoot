package com.winter.app.board.qna;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QnaDTO {
	private Long boardNum;
	private String boardTitle;
	private String boardWriter;
	private String boardContents;
	private Date boardDate;
	private Long boardHit;
	private Long boardRef;
	private Long boardStep;
	private Long boardDepth;
	
}
