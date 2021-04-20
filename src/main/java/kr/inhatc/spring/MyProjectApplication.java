package kr.inhatc.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
//첨부파일과 관련된 자동 구성을 사용하지 않도록 설정, 원래는 class를 불러서 처리하는데 그 과정을 배제
@SpringBootApplication(exclude = {MultipartAutoConfiguration.class})
public class MyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProjectApplication.class, args);
	}

}
