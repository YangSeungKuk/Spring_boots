package kr.inhatc.spring.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.inhatc.spring.board.dto.BoardDto;
import kr.inhatc.spring.board.service.BoardService;
import kr.inhatc.spring.user.entity.Users;
import kr.inhatc.spring.user.service.UserService;

@Controller

public class UserController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	
	//요구가 들어올때 맵핑, localhost의 포트번호로 들어오면
	//기본적으로 html파일을 찾아감
	@RequestMapping("/")
	//Hello 출력하는 매서드
	public String hello() {
		
		return "redirect:/user/userList";
	}
	
	//GET(read), POST(create), PUT(update), DELETE(delete)
	
	//@GetMapping value값만 적으면 쓸수 있게
	@RequestMapping(value = "/user/userList", method=RequestMethod.GET)
	public String userList(Model model) {
		List<Users> list = userService.userList();
		model.addAttribute("list", list);
		// 내이동
		return "user/userList";  
	}
	
}
