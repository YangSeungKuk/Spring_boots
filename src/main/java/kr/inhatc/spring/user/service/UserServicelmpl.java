package kr.inhatc.spring.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.user.entity.Users;
import kr.inhatc.spring.user.repository.UserRepository;

@Service
public class UserServicelmpl implements UserService{

	@Autowired
	UserRepository userRespository;
	
	@Override
	public List<Users> userList() {
		List<Users> list =  userRespository.findAllByOrderByIdDesc();
		return list;
	}

}
