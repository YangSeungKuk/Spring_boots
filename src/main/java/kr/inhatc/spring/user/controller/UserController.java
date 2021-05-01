package kr.inhatc.spring.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.inhatc.spring.board.dto.BoardDto;
import kr.inhatc.spring.board.service.BoardService;
import kr.inhatc.spring.user.entity.Users;
import kr.inhatc.spring.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
//@RequestMapping("/user")
//@RequiredArgsConstructor
public class UserController {

	// logger
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
//	private UserService userService; Autowired안쓸려면 class위에 @RequiredArgsConstructor를 쓰고 final 넣어주기
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
	//@GetMapping("/userList")
	@RequestMapping(value = "/user/userList", method=RequestMethod.GET)
	public String userList(Model model) {
		
		log.info("================> 리스트 수행중 .......");
		
		List<Users> list = userService.userList();
		System.out.println("===================> 크기" + list.size());
		model.addAttribute("list", list);
		
		return "user/userList";  
	}
	
	@RequestMapping(value = "/user/userInsert", method=RequestMethod.GET)
	public String userWrite() {
		
		return "user/userWrite";  
	}
	
	//만들러갈땐 POST
	@RequestMapping(value = "/user/userInsert", method=RequestMethod.POST)
	public String userInsert(Users user) {
		userService.saveUsers(user);
		return "redirect:/user/userList";  
	}
	
	//userlist에서 받아오는 정보
	@RequestMapping(value = "/user/userDetail/{id}", method=RequestMethod.GET)
	public String userDetail(@PathVariable("id") String id, Model model) {
		Users user = userService.userDetail(id);
		model.addAttribute("user", user);
		System.out.println("==================>" + user);
		return "user/userDetail";  
	}
	
	@RequestMapping(value = "/user/userUpdate/{id}", method=RequestMethod.POST)
	public String userUpdate(@PathVariable("id") String id, Users user) {
		System.out.println("==================>" + user);
		
		//아이디 설정
		user.setId(id);
		System.out.println("==================>" + user);
		userService.saveUsers(user);
		return "redirect:/user/userList";  
	}
	
	@RequestMapping(value = "/user/userDelete/{id}", method=RequestMethod.GET)
	public String userDelete(@PathVariable("id") String id) {
		
		userService.userDelete(id);
		
		return "redirect:/user/userList";  
	}
	
//	@GetMapping({"/test", "/test2"})
//	public void test() {
//		
//	}
//	
//	@RequestMapping("/test")
//	public String test2() {
//		return "user/test";
//	}
}