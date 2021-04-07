package kr.inhatc.spring.board.dto;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BoardDto {

		private int boardIdx;
		private String title;
		private String contents;
		private int hitCnt;
		private String createId;
		private String createDate;
		//private Date createDate;
		
}
