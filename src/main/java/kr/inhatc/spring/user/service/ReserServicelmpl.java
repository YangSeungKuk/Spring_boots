package kr.inhatc.spring.user.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sun.el.stream.Optional;

import kr.inhatc.spring.user.entity.Resers;
import kr.inhatc.spring.user.entity.Users;
import kr.inhatc.spring.user.repository.FileRepository;
import kr.inhatc.spring.user.repository.ReserRepository;
import kr.inhatc.spring.user.repository.UserRepository;
import kr.inhatc.spring.utils.FileUtiles;


@Service
public class ReserServicelmpl implements ReserService{

	@Autowired
	UserRepository userRespository;
	
	@Autowired
	FileRepository fileRepository;
	
	@Autowired
	private FileUtiles fileUtiles;
	
	@Autowired
	private ReserRepository reserRepository;

	@Override
	public void saveReser(Resers reser) {
		System.out.println("123.. : "+ reser);
		reserRepository.save(reser);
	}


	@Override
	public List<Resers> reserList() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Resers reserInfo(String name) {
		System.out.println("durlsms : " + name);
		Resers opt = reserRepository.findAllByUserid(name);
		System.out.println("fethsf : " + opt);
		return opt;
	}


	

}


