package kr.inhatc.spring.board.service;

import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.inhatc.spring.board.dto.BoardDto;
import kr.inhatc.spring.board.dto.FileDto;
import kr.inhatc.spring.board.mapper.BoardMapper;
import kr.inhatc.spring.utils.FileUtils;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Autowired
	private FileUtils fileUtils;
	
	@Override
	public List<BoardDto> boardList() {
		
		return boardMapper.boardList();
	}

	@Override
    public void boardInsert(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest) {
        boardMapper.boardInsert(board);
//        System.out.println("여기 됨?");
        
        // 파일 임시확인 
//        if(ObjectUtils.isEmpty(multipartHttpServletRequest) == false) {
////            System.out.println("여기 eHLD");
//        	Iterator<String> iter = multipartHttpServletRequest.getFileNames();
////            System.out.println("읎냐? : "+ iter.hasNext());
//            // 다음 내용이 있는지 확인
//            while(iter.hasNext()) {
//                String name = iter.next();
//
//                List<MultipartFile> list = multipartHttpServletRequest.getFiles(name);
//                for(MultipartFile multipartFile : list) {
//                    System.out.println("==============> file name : "+ multipartFile.getOriginalFilename());
//                    System.out.println("==============> file size : "+ multipartFile.getSize());
//                    System.out.println("==============> file type : "+ multipartFile.getContentType());
//                }
//            }
//        }
        //1. 파일 저장
        List<FileDto> list = fileUtils.parseFileInfo(board.getBoardIdx(), multipartHttpServletRequest);
        
        //2. db 저장
        if(CollectionUtils.isEmpty(list) == false) {
        	boardMapper.boardFileInsert(list);
        }
        
    }

	@Override
	public BoardDto boardDetail(int boardIdx) {
		BoardDto board = boardMapper.boardDetail(boardIdx);
		
		//파일 정보
		List<FileDto> fileList = boardMapper.selectBoardFileList(boardIdx);
		board.setFileList(fileList);
		
		boardMapper.updateHit(boardIdx);
		return board;
	}

	@Override
	public void boardUpdate(BoardDto board) {
		boardMapper.boardUpdate(board);
		
	}

	@Override
	public void boardDelete(int boardIdx) {
		boardMapper.boardDelete(boardIdx);
		
	}

	@Override
	public FileDto selectFileInfo(int idx, int boardIdx) {
		FileDto boardFile = boardMapper.selectFileInfo(idx, boardIdx);
		
		return boardFile;
	}

	
	
	
}
