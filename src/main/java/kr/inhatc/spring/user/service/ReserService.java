package kr.inhatc.spring.user.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.inhatc.spring.user.entity.Resers;
import kr.inhatc.spring.user.entity.Users;

public interface ReserService {

	void saveReser(Resers reser);

	List<Resers> reserList();

	Resers reserInfo(String name);



}
