package kr.inhatc.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

// Adapter클래스는 리스너 인터페이스를 구현하여 리스너 인터페이스의 추상메서드로 정의되어 있는 메서드를 모두 다 정의해 놓은 클래스
@EnableWebSecurity //보안처리
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity security) throws Exception {
		// 루트로 들어오사람은 아무나 들오게 할 수 있음
//		security.authorizeRequests().antMatchers("/", "/login/**", "/user/**", "/boardjpa/**").permitAll();
		security.authorizeRequests().antMatchers("/", "/login/**", "/user/userInsert", "/user/map" , "/user/roomthema").permitAll();
		
		// 인증된 사용자만 들어오게 할 수 있음
		security.authorizeRequests().antMatchers("/user/**").hasRole("ADMIN");
		security.authorizeRequests().antMatchers("/boardjpa/**").hasAnyRole("MEMBER", "ADMIN");
		
		//상호참조? 변조를 방지하게 해주는 곳
		//RESTfull 을 사용하기 위해 비활성화
		security.csrf().disable();
		
		//시스템이 제공하는 로그인창
//		security.formLogin();
	
		//만든 로그인창 현재 문제되서 닫아놓음
		security.formLogin().loginPage("/login/login").defaultSuccessUrl("/", true);
		
		security.exceptionHandling().accessDeniedPage("/login/accessDenied");
		
		security.logout().logoutUrl("/login/logout").invalidateHttpSession(true).logoutSuccessUrl("/");
	}
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 패스워드에 암호화 처리
	 * 2. 처리내용 : 암호화 처리
	 * </pre>
	 * @return
	 */
	//Bean으로 아무대서나 쓸수 있게 됨
	@Bean
	public PasswordEncoder passwordEncoder() {
		//                              createDelegatingPasswordEncoder() : 원패스 암호화
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
