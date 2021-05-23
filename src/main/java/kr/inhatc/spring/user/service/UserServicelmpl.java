package kr.inhatc.spring.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.el.stream.Optional;

import kr.inhatc.spring.user.entity.Users;
import kr.inhatc.spring.user.repository.UserRepository;

@Service
public class UserServicelmpl implements UserService{

	@Autowired
	UserRepository userRespository;
	
	
	@Override
	public List<Users> userList() {

//		userRespository.findAllByOrderByIdDesc();
		
//		Optional<Users> result = userRespository.findById("ab");
//		if(result.isPresent()) {
//			Users user = result.get();
//			user.getId();
//		} 
		
		//findAll 다 땡겨온다.
		//userRepository.findAll()
		
		List<Users> list =  userRespository.findAllByOrderByIdDesc();
		return list;
	}

	@Override
	public void saveUsers(Users user) {
		userRespository.save(user);
	}

	@Override
	public Users userDetail(String id) {
		java.util.Optional<Users> optional = userRespository.findById(id);
		if(optional.isPresent()) {
			Users user = optional.get();
			return user;
		} else {
			throw new NullPointerException();
		}
	}

	@Override
	public void userDelete(String id) {
		userRespository.deleteById(id);
		
	}

}
