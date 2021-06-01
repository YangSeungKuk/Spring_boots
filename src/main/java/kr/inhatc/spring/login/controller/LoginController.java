package kr.inhatc.spring.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class LoginController {
	
	@GetMapping("/login/login")
	public void login() {
		log.info("로그인 진행중....");
	}
	
	@GetMapping("/login/accessDenied")
	public void accessDenied(HttpServletResponse response, HttpServletRequest request ) {
		try {
			ScriptUtils.alertAndMovePage(response, "접근 권한이 없습니다. 메인으로 돌아갑니다.	", "http://localhost:18080/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		log.info("접근 거부...");
	}
	
	@GetMapping("/login/logout")
	public void logout() {

		
		log.info("로그아웃...");
	}
}
