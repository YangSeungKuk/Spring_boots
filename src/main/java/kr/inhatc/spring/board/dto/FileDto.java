package kr.inhatc.spring.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor 인자넣어서 생성자 생성
//@NoArgsConstructor  비어있는 생성자 생성
public class FileDto {

	private int idx;
	private int boardIdx;
	private String originalFileName;
	private String storedFilePath;
	private long fileSize;
	
}
