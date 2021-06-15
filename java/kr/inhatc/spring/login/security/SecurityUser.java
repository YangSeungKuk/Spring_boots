package kr.inhatc.spring.login.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import kr.inhatc.spring.user.entity.Users;

//원래는 implements userDetails로 연결해야 하지만 구현해야할 메소드가 많아진다.
//따라서 User라는 시큐리티 코어를 extends해서 연결
public class SecurityUser extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Users user;
	
	//시큐리티 코어인 User의 생성자 생성
	//SecurityUserDetailService에서 보내는 user를 인자값으로 받음
	public SecurityUser(Users user) {
		//db에서 설정한 role로 권한 부여
		// 암호화 처리 전까지는 패스워드 앞에 {noop} 추가, AuthorityUtils는 권한을 관리, createAuthorityList로 권한 리스트 작성
		super(user.getId(), user.getPw(), AuthorityUtils.createAuthorityList(user.getRole()));
		//받아온 유저로 초기화
		this.user = user;
	}

}
