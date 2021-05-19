package kr.inhatc.spring.user.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.inhatc.spring.user.entity.Users;

@SpringBootTest //유닛 테스트할려면 넣어야됨
class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void insertTest() {
		Users user = Users.builder()
				.id("abc")
				.pw("111")
				.email("abc@sss.com")
				.build();
		
		userRepository.save(user);
	}
	
	@Test
	void findAllByOrderByIdDescTest() {
		List<Users> list =  userRepository.findAllByOrderByIdDesc();
		System.out.println("===========test============== ");
		for (Users users : list) {
			System.out.println(users);
		}
	}

}
