package kr.inhatc.spring.board.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@NoArgsConstructor 빈 생성자 만드는 어노테이션
//@AllArgsConstructor 모든 생성자 만드는 어노테이션
@Data
public class BoardDto {

		private int boardIdx;
		private String title;
		private String contents;
		private int hitCnt;
		private String createId;
		private String createDate;
		//private Date createDate;
		
		//파일 관리를 위한 리스트 추가
		private List<FileDto> fileList;
		
}
