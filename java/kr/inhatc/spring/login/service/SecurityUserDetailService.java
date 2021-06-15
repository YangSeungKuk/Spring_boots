package kr.inhatc.spring.login.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.login.security.SecurityUser;
import kr.inhatc.spring.user.entity.Users;
import kr.inhatc.spring.user.repository.UserRepository;

//db에 있는 유저 정보로 로그인 하기 위한 곳
//시큐리티 코어에 있는 유저디테일서비스 인터페이스 연결
@Service
public class SecurityUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	//유저디테일서비스에서 만들어야 하는 객체
	@Override                                                  //유저를 못찾을 경우 예외처리
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Users> optional = userRepo.findById(username);
		
		//isPresent : 존재한다면
		if(optional.isPresent()) {
			Users user = optional.get();
			System.out.println("!@#!@#!@#!@#> " + user);
			
			return new SecurityUser(user); //반환타입이 인터페이스인 UserDetails, login/security에 SecurityUser클래스 생성
		} else {
			throw new UsernameNotFoundException(username + "사 용 자 없 음 ! ! !");
		}

	}
	
}
