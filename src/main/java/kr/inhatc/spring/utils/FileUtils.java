package kr.inhatc.spring.utils;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.inhatc.spring.board.dto.FileDto;

@Component
public class FileUtils {

	public List<FileDto> parseFileInfo(int boardIdx, MultipartHttpServletRequest multipartHttpServletRequest){
		
		if(ObjectUtils.isEmpty(multipartHttpServletRequest)) {
			return null;
		}
		
		List<FileDto> fileList = new ArrayList<FileDto>();
		
		//파일이 업로드 될 폴더 생성
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
		ZonedDateTime current = ZonedDateTime.now();
		String path = "images/" + current.format(format);
		
		File file = new File(path);
		if(file.exists() == false) { //폴더없으면 만들고 있으면 path
			file.mkdir();
		}
		
		Iterator<String> iter = multipartHttpServletRequest.getFileNames();
		
		// 원래 확장자
		String originalFileExtension = null;
		
		//원소가 있을때 까지 부르나.
		while(iter.hasNext()) {
			//리스트 뽑기
			List<MultipartFile> list = multipartHttpServletRequest.getFiles(iter.next());
			
			for (MultipartFile multipartFile : list) {
				if(multipartFile.isEmpty() == false) {
					//타입을 가져옴
					String contentType = multipartFile.getContentType();
					if(ObjectUtils.isEmpty(contentType)) {
						break;
					} else {
						if(contentType.contains("image/jpeg")) {
							originalFileExtension = ".jpg";
						} else if(contentType.contains("image/png")) {
							originalFileExtension = ".png";
						} else if(contentType.contains("image/gif")) {
							originalFileExtension = ".gif";
						} else {
							break;
						}
					}
					//중복된 이름을 없애 위해서, 새 파일 이름
					String newFileName = Long.toString(System.nanoTime()) + originalFileExtension;
					
					FileDto boardFile = new FileDto(); //파일을 저장하기 위해
					 //db에 저장할 정보들
					boardFile.setBoardIdx(boardIdx);
					boardFile.setFileSize(multipartFile.getSize());
					boardFile.setOriginalFileName(multipartFile.getOriginalFilename());
					boardFile.setStoredFilePath(path + "/" + newFileName);
					fileList.add(boardFile);
					
					file = new File(path + "/" + newFileName);
					try {
						//파일을 실제로 만드는 부분
						multipartFile.transferTo(file);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return fileList;
	}
}
