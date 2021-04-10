package kr.inhatc.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.inhatc.spring.board.dto.BoardDto;
import kr.inhatc.spring.board.service.BoardService;

//메모리에 올리기 위해
//결과물을 바로 받아올때, 웹사이트로 접속할때는 Controller로, 컨트롤러라고 적어줘야 컨트롤러로 설정 
//@RestController 결과물을 바로 받아올때 사용
@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	
	//요구가 들어올때 맵핑, localhost의 포트번호로 들어오면
	//기본적으로 html파일을 찾아감
	@RequestMapping("/")
	//Hello 출력하는 매서드
	public String hello() {
		return "index";
	}
	
	@RequestMapping("/board/boardList")
	//mvc model -> 데이터를 다루는 것, view -> html, controller -> 요청을 하면 url로 받아 return 
	//model은 파이썬의 딕셔너리 같은 것 키 값 중요
	public String boardList(Model model) {
		// 서비스 로직
		List<BoardDto> list = boardService.boardList();
		System.out.println(">>>>>>>>>>>>>>>>>" + list.size());
		//System.out.println(list.get(0));
		model.addAttribute("list", list);
		//model.addAttribute("name", "홍길동");
		
		// 뷰어 이동
		return "board/boardList";
	}
	
	@RequestMapping("/board/boardWrite")
	public String boardWrite() {
		// 뷰어 이동
		return "board/boardWrite";
	}
	
	@RequestMapping("/board/boardInsert")
	public String boardInsert(BoardDto board) {
		boardService.boardInsert(board);
		// 뷰어 이동
		return "redirect:/board/boardList";
	}
}
